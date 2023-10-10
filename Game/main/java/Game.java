package com.example.user.game;

import Helpers.frequencyfunctions.Note;
import Helpers.tabsparsing.tabsParser;
import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private Object sharedNoteLock = new Object();
    private double sharedNote;
    private TextView[] strings = new TextView[6];

    private String unparsedTabs =
                    "e|-4--4--4---4--4--4---4--7--------4---5--5--5--5-5--4--4--4--4-2--2--4--2---7-------------------\n" +
                    "B|---------------------------5--7----------------------------------------------------------------\n" +
                    "G|-----------------------------------------------------------------------------------------------\n" +
                    "D|-----------------------------------------------------------------------------------------------\n" +
                    "A|-----------------------------------------------------------------------------------------------\n" +
                    "E|-----------------------------------------------------------------------------------------------\n" +
                    "e|-0--4--4----4--4--4-----4--7--------4----------5--5--5---5-5--4--4--4-4--7--7--5---------------\n" +
                    "B|------------------------------5---7-----------------------------------------------7--5---------\n" +
                    "G|-----------------------------------------------------------------------------------------------\n" +
                    "D|-----------------------------------------------------------------------------------------------\n" +
                    "A|-----------------------------------------------------------------------------------------------\n" +
                    "E|-----------------------------------------------------------------------------------------------\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final tabsParser tabHandler = new tabsParser(unparsedTabs);
        strings[0] = (TextView) findViewById(R.id.string1);
        strings[1] = (TextView) findViewById(R.id.string2);
        strings[2] = (TextView) findViewById(R.id.string3);
        strings[3] = (TextView) findViewById(R.id.string4);
        strings[4] = (TextView) findViewById(R.id.string5);
        strings[5] = (TextView) findViewById(R.id.string6);

        for (short i = 0;i<6;i++)
        {
            strings[i].setText(tabHandler.getString(i));
        }

        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);


        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult res, AudioEvent e) {
                final double note = Note.frequencyToNote(res.getPitch());
                synchronized (sharedNoteLock) {
                    sharedNote = note;
                }
            }
        };

        AudioProcessor pitchProcessor = new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(pitchProcessor);
        Thread audioThread = new Thread(dispatcher, "Audio Thread");
        audioThread.start();

        new Thread(new Runnable() {
            public void run() {
                begin(tabHandler);
            }
        }).start();
    }

    private void begin(tabsParser tabHandler) {
        double note;
        boolean success, redLine, space; //flags
        double cmpNote;
        int i = 0;
        long startTime = 0;

        do {
            note = tabHandler.getNextNote();
            redLine = false;
            i++;
            space = true;
            if (note != 0 && note != -1) {
                space = false;
                success = false;
                startTime = System.nanoTime();
                do {
                    synchronized (sharedNoteLock) {
                        cmpNote = sharedNote;
                    }
                    if (cmpNote == note) {
                        success = true;
                    }
                    else if (!redLine && System.nanoTime() - startTime > 450000000){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ImageView line = (ImageView) findViewById(R.id.line);
                                line.setImageResource(R.color.red);
                            }
                        });
                        redLine = true;
                    }
                } while (!success);
            }

            if (space)
            {
                try {
                    Thread.sleep(240);
                } catch (InterruptedException e) {
                }
            }
            else
            {
                if (redLine) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ImageView line = (ImageView) findViewById(R.id.line);
                            line.setImageResource(R.color.green);
                        }
                    });
                }
                else
                {
                    try {
                        Thread.sleep(450 - ((System.nanoTime() - startTime) / 1000000));
                    } catch (InterruptedException e) {

                    }
                }
            }
            if (i>3) {
                presentNextNote();
            }
        } while (note != -1);
    }

    private void presentNextNote()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (short i = 0;i<6;i++)
                {
                    strings[i].setText(((String)strings[i].getText()).substring(1));
                }
            }
        });
    }
}
