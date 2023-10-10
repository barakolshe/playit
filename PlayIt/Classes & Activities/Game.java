package application.playit;

import application.playit.runnables.NoteRunnable;
import application.playit.frequency_processors.Processor;
import application.playit.TabsHandler;
import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    private Object sharedNoteLock = new Object();
    private Object pointsLock = new Object();
    private double sharedNote;
    private long points = 0;
    private TextView text;
    private ConstraintLayout layout;
    private ConstraintSet set;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle args = getIntent().getExtras();
        final TabsHandler tabs = new TabsHandler(args.getString("tabs"));

        text = (TextView) findViewById(R.id.points);
        layout = (ConstraintLayout)findViewById(R.id.mainLayout);
        set = new ConstraintSet();
        db = new Database(getApplicationContext());

        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult res, AudioEvent e) {
                final double note = Processor.guitarNotesProcessor(res.getPitch());
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
                begin(tabs, 200);
            }
        }).start();
    }

    private void begin(TabsHandler tabs, int time) {
        int string;
        char noteChar;
        int id = 50;
        long elapsedTime = 0;

        do {
            elapsedTime = 0;
            string = tabs.getString();
            if (string != 0 && string != -1) {
                final long startTime = System.currentTimeMillis();
                noteChar = tabs.getNextNoteChar();
                Animation slide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);

                ImageView image = new ImageView(this);
                switch (noteChar) {
                    case '0':
                        image.setImageResource(R.drawable.num0);
                        break;
                    case '1':
                        image.setImageResource(R.drawable.num1);
                        break;
                    case '2':
                        image.setImageResource(R.drawable.num2);
                        break;
                    case '3':
                        image.setImageResource(R.drawable.num3);
                        break;
                    case '4':
                        image.setImageResource(R.drawable.num4);
                        break;
                    case '5':
                        image.setImageResource(R.drawable.num5);
                        break;
                    case '6':
                        image.setImageResource(R.drawable.num6);
                        break;
                    case '7':
                        image.setImageResource(R.drawable.num7);
                        break;
                    case '8':
                        image.setImageResource(R.drawable.num8);
                        break;
                    case '9':
                        image.setImageResource(R.drawable.num9);
                        break;
                    default:
                        image.setImageResource(R.drawable.ic_launcher_background);
                }
                image.setId(id);
                final ImageView image2 = image;
                slide.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //Create handler on the current thread (UI thread)
                        Handler h = new Handler();
                        //Run a runnable after 100ms (after that time it is safe to remove the view)
                        h.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ((ViewGroup) image2.getParent()).removeView(image2);
                            }
                        }, 100);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });

                final int margin = string * 150;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        layout.addView(image2);
                        set.clone(layout);
                        set.connect(image2.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, margin);
                        set.connect(image2.getId(), ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT, 0);
                        set.applyTo(layout);
                    }
                });

                image.startAnimation(slide);
                id += 50;

                new Thread(new NoteRunnable(tabs.getNextNote())
                {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(7450);
                        } catch (InterruptedException e) {

                        }
                        long endTime = 600 + System.currentTimeMillis();
                        boolean hit = false;
                        do
                        {
                            synchronized (sharedNoteLock) {
                                if (note == sharedNote) {
                                    hit = true;
                                }
                            }
                        }while (endTime<System.currentTimeMillis() && !hit);
                        if (hit)
                        {
                            synchronized (pointsLock) {
                                points++;
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        text.setText(String.valueOf(points * 100));
                                    }
                                });
                            }
                        }
                    }
                }).start();
                elapsedTime = (System.currentTimeMillis() - startTime);
            }
            try {
                Thread.sleep(250 - elapsedTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(string != -1);
    }
}
