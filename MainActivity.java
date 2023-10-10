package com.example.user.tuner;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {
    /*A notes constants*/
    private boolean switchFirstEnterance = false;

    private static final double A0 = 27.5;
    private static final double A_S_0 = 29.14;

    private static final double A_F_1 = 51.91;
    private static final double A1 = 55;
    private static final double A_S_1 = 58.27;

    private static final double A_F_2 = 103.83;
    private static final double A2 = 110;
    private static final double A_S_2 = 116.54;

    private static final double A_F_3 = 207.65;
    private static final double A3 = 220;
    private static final double A_S_3 = 233.08;

    private static final double A_F_4 = 415.30;
    private static final double A4 = 440;
    private static final double A_S_4 = 466.16;

    private static final double A_F_5 = 830.61;
    private static final double A5 = 880;
    private static final double A_S_5 = 932.33;

    private static final double A_F_6 = 1661.22;
    private static final double A6 = 1760;
    private static final double A_S_6 = 1864.66;

    /*B notes constant*/

    private static final double B_F_0 = 29.14;
    private static final double B0 = 30.87;

    private static final double B_F_1 = 58.27;
    private static final double B1 = 61.74;

    private static final double B_F_2 = 116.54;
    private static final double B2 = 123.47;

    private static final double B_F_3 = 233.08;
    private static final double B3 = 246.94;

    private static final double B_F_4 = 466.16;
    private static final double B4 = 493.88;

    private static final double B_F_5 = 932.33;
    private static final double B5 = 987.77;

    private static final double B_F_6 = 1864.66;
    private static final double B6 = 1975.53;

    /*C notes constants*/

    private static final double C1 = 32.70;
    private static final double C_S_1 = 34.65;

    private static final double C2 = 65.41;
    private static final double C_S_2 = 69.30;

    private static final double C3 = 130.81;
    private static final double C_S_3 = 138.59;

    private static final double C4 = 261.63;
    private static final double C_S_4 = 277.18;

    private static final double C5 = 523.25;
    private static final double C_S_5 = 554.37;

    private static final double C6 = 1046.50;
    private static final double C_S_6 = 1108.73;

    private static final double C7 = 2093.00;
    private static final double C_S_7 = 2217.46;

    /*D notes constants*/

    private static final double D_F_1 = 34.65;
    private static final double D1 = 36.71;
    private static final double D_S_1 = 38.89;

    private static final double D_F_2 = 69.30;
    private static final double D2 = 73.42;
    private static final double D_S_2 = 77.78;

    private static final double D_F_3 = 138.59;
    private static final double D3 = 146.83;
    private static final double D_S_3 = 155.56;

    private static final double D_F_4 = 277.18;
    private static final double D4 = 293.66;
    private static final double D_S_4 = 311.13;

    private static final double D_F_5 = 554.37;
    private static final double D5 = 587.33;
    private static final double D_S_5 = 622.25;

    private static final double D_F_6 = 1108.73;
    private static final double D6 = 1174.66;
    private static final double D_S_6 = 1244.51;

    private static final double D_F_7 = 2217.46;
    private static final double D7 = 2349.32;
    private static final double D_S_7 = 2489.02;

    /*E notes constants*/

    private static final double E_F_1 = 38.89;
    private static final double E1 = 41.20;

    private static final double E_F_2 = 77.78;
    private static final double E2 = 82.41;

    private static final double E_F_3 = 155.56;
    private static final double E3 = 164.81;

    private static final double E_F_4 = 311.13;
    private static final double E4 = 329.63;

    private static final double E_F_5 = 622.25;
    private static final double E5 = 659.25;

    private static final double E_F_6 = 1244.51;
    private static final double E6 = 1318.51;

    private static final double E_F_7 = 2489.02;
    private static final double E7 = 2637.02;


    /*F notes constants*/


    private static final double F1 = 43.65;
    private static final double F_S_1 = 46.25;

    private static final double F2 = 87.31;
    private static final double F_S_2 = 92.50;

    private static final double F3 = 174.61;
    private static final double F_S_3 = 185.00;

    private static final double F4 = 349.23;
    private static final double F_S_4 = 369.99;

    private static final double F5 = 698.46;
    private static final double F_S_5 = 739.99;

    private static final double F6 = 1396.91;
    private static final double F_S_6 = 1479.98;

    private static final double F7 = 2793.83;
    private static final double F_S_7 = 2959.96;

    /*G notes constants*/

    private static final double G_F_1 = 46.25;
    private static final double G1 = 49.00;
    private static final double G_S_1 = 51.91;

    private static final double G_F_2 = 92.50;
    private static final double G2 = 98.00;
    private static final double G_S_2 = 103.83;

    private static final double G_F_3 = 185.00;
    private static final double G3 = 196.00;
    private static final double G_S_3 = 207.65;

    private static final double G_F_4 = 369.99;
    private static final double G4 = 392.00;
    private static final double G_S_4 = 415.30;

    private static final double G_F_5 = 739.99;
    private static final double G5 = 783.99;
    private static final double G_S_5 = 830.61;

    private static final double G_F_6 = 1479.98;
    private static final double G6 = 1567.98;
    private static final double G_S_6 = 1661.22;

    private static final double G_F_7 = 2959.96;
    private static final double G7 = 3135.96;
    private static final double G_S_7 = 3322.44;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Program stuff:

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch methodSwitch = (Switch) findViewById(R.id.methodSwitch);
        methodSwitch.setOnCheckedChangeListener(this);
        //Audio part:

        AudioDispatcher dispatcher =
                AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);
        PitchDetectionHandler pdh = new PitchDetectionHandler() {
            @Override
            public void handlePitch(PitchDetectionResult res, AudioEvent e) {
                final float pitchInHz = res.getPitch();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        processPitch(pitchInHz);
                    }
                });
            }
        };
        AudioProcessor pitchProcessor = new PitchProcessor(PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(pitchProcessor);
        Thread audioThread = new Thread(dispatcher, "Audio Thread");
        audioThread.start();
    }


    public void ELOnClick(View v) {
        TextView note = (TextView) findViewById(R.id.tuneNote);
        note.setText("EL");
    }

    public void AOnClick(View v) {
        TextView note = (TextView) findViewById(R.id.tuneNote);
        note.setText("A");
    }

    public void DOnClick(View v) {
        TextView note = (TextView) findViewById(R.id.tuneNote);
        note.setText("D");
    }

    public void GOnClick(View v) {
        TextView note = (TextView) findViewById(R.id.tuneNote);
        note.setText("G");
    }

    public void BOnClick(View v) {
        TextView note = (TextView) findViewById(R.id.tuneNote);
        note.setText("B");
    }

    public void EHOnClick(View v) {
        TextView note = (TextView) findViewById(R.id.tuneNote);
        note.setText("EH");
    }

    public void AutoOnClick(View v) {
        TextView note = (TextView) findViewById(R.id.tuneNote);
        note.setText("");
    }

    private void processPitch(float f) {

        TextView noteText = (TextView) findViewById(R.id.noteT);
        TextView gapText = (TextView) findViewById(R.id.gapT);
        TextView tuneNote = (TextView) findViewById(R.id.tuneNote);
        TextView methodType = (TextView) findViewById(R.id.methodType);

        if (f == -1) {
            noteText.setText("N/A");
            gapText.setText("N/A");
        }
        else if (methodType.getText().toString() == "E" || !switchFirstEnterance) {
            switch (tuneNote.getText().toString()) {
                case "EL": {
                    noteText.setText("E");
                    gapText.setText("" + (f - E2));
                    break;
                }
                case "A": {
                    noteText.setText("A");
                    gapText.setText("" + (f - A2));
                    break;
                }
                case "D": {
                    noteText.setText("D");
                    gapText.setText("" + (f - D3));
                    break;
                }
                case "G": {
                    noteText.setText("G");
                    gapText.setText("" + (f - G3));
                    break;
                }
                case "B": {
                    noteText.setText("B");
                    gapText.setText("" + (f - B3));
                    break;
                }
                case "EH": {
                    noteText.setText("E");
                    gapText.setText("" + (f - E4));
                    break;
                }
                default: {
                    if (f < E2) {
                        noteText.setText("E");
                        gapText.setText("" + (f - E2));
                    } else if (f >= E2 && f < A2) {
                        if (f <= E2 + ((A2 - E2) / 2)) {
                            noteText.setText("E");
                            gapText.setText("+" + (E2 - f));
                        } else {
                            noteText.setText("A");
                            gapText.setText("-" + (A2 - f));
                        }
                    } else if (f >= A2 && f < D3) {
                        if (f <= A2 + ((D3 - A2) / 2)) {
                            noteText.setText("A");
                            gapText.setText("+" + (A2 - f));
                        } else {
                            noteText.setText("D3");
                            gapText.setText("-" + (D3 - f));
                        }
                    } else if (f >= D3 && f < G3) {
                        if (f <= D3 + ((G3 - D3) / 2)) {
                            noteText.setText("D");
                            gapText.setText("+" + (D3 - f));
                        } else {
                            noteText.setText("G");
                            gapText.setText("-" + (G3 - f));
                        }
                    } else if (f >= G3 && f < B3) {
                        if (f <= G3 + ((B3 - G3) / 2)) {
                            noteText.setText("G");
                            gapText.setText("+" + (G3 - f));
                        } else {
                            noteText.setText("B");
                            gapText.setText("-" + (B3 - f));
                        }
                    } else if (f >= B3 && f < E4) {
                        if (f <= B3 + ((E4 - B3) / 2)) {
                            noteText.setText("B");
                            gapText.setText("+" + (B3 - f));
                        } else {
                            noteText.setText("E");
                            gapText.setText("-" + (E4 - f));
                        }
                    } else {
                        noteText.setText("E");
                        gapText.setText("-" + (E4 - f));
                    }
                }
            }
        }
        else
        {
            //advanced tuner
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        TextView methodType = (TextView) findViewById(R.id.methodType);

        switchFirstEnterance = true; //unexplained error where the system doesn't recognise default text "E" on methodType TextView.

        if (isChecked)
        {
            methodType.setText("E");

            Button tuneEL = (Button) findViewById(R.id.tuneEL);
            Button tuneA = (Button) findViewById(R.id.tuneA);
            Button tuneG = (Button) findViewById(R.id.tuneG);
            Button tuneD = (Button) findViewById(R.id.tuneD);
            Button tuneB = (Button) findViewById(R.id.tuneB);
            Button tuneEH = (Button) findViewById(R.id.tuneEH);
            Button tuneAuto = (Button) findViewById(R.id.tuneAuto);

            tuneEL.setEnabled(true);
            tuneA.setEnabled(true);
            tuneG.setEnabled(true);
            tuneD.setEnabled(true);
            tuneB.setEnabled(true);
            tuneEH.setEnabled(true);
            tuneAuto.setEnabled(true);

            tuneEL.setVisibility(View.VISIBLE);
            tuneA.setVisibility(View.VISIBLE);
            tuneG.setVisibility(View.VISIBLE);
            tuneD.setVisibility(View.VISIBLE);
            tuneB.setVisibility(View.VISIBLE);
            tuneEH.setVisibility(View.VISIBLE);
            tuneAuto.setVisibility(View.VISIBLE);
        }
        else
        {
            methodType.setText("A");

            Button tuneEL = (Button) findViewById(R.id.tuneEL);
            Button tuneA = (Button) findViewById(R.id.tuneA);
            Button tuneG = (Button) findViewById(R.id.tuneG);
            Button tuneD = (Button) findViewById(R.id.tuneD);
            Button tuneB = (Button) findViewById(R.id.tuneB);
            Button tuneEH = (Button) findViewById(R.id.tuneEH);
            Button tuneAuto = (Button) findViewById(R.id.tuneAuto);

            tuneEL.setEnabled(false);
            tuneA.setEnabled(false);
            tuneG.setEnabled(false);
            tuneD.setEnabled(false);
            tuneB.setEnabled(false);
            tuneEH.setEnabled(false);
            tuneAuto.setEnabled(false);

            tuneEL.setVisibility(View.GONE);
            tuneA.setVisibility(View.GONE);
            tuneG.setVisibility(View.GONE);
            tuneD.setVisibility(View.GONE);
            tuneB.setVisibility(View.GONE);
            tuneEH.setVisibility(View.GONE);
            tuneAuto.setVisibility(View.GONE);
        }
    }
}