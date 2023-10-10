package application.playit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;
import android.widget.CompoundButton;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Button;
import application.playit.frequency_processors.Processor;

public class Tuner extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private short string = 0;
    private String lastNote = "N/A";
    private String lastGap = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuner);


        Switch methodSwitch = (Switch) findViewById(R.id.Mode);
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
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        };
        AudioProcessor pitchProcessor = new PitchProcessor(PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, pdh);
        dispatcher.addAudioProcessor(pitchProcessor);
        Thread audioThread = new Thread(dispatcher, "Audio Thread");
        audioThread.start();
    }

    public void AutoOnClick(View v) {
        string = 0;
    }

    public void EHOnClick(View v) {
        string = 1;
    }

    public void BOnClick(View v) {
        string = 2;
    }

    public void GOnClick(View v) {
        string = 3;
    }

    public void DOnClick(View v) {
        string = 4;
    }

    public void AOnClick(View v) {
        string = 5;
    }

    public void ELOnClick(View v) {
        string = 6;
    }

    private void processPitch(double f) {

        TextView noteText = (TextView) findViewById(R.id.note);
        TextView gapText = (TextView) findViewById(R.id.gap);
        Switch mode = (Switch) findViewById(R.id.Mode);

        if (f == -1)
        {
            noteText.setText(lastNote);
            gapText.setText(lastGap);
        }
        else if (mode.isChecked() == true)
        {
            switch (string)
            {
                case 1:
                    noteText.setText("High E");
                    gapText.setText("" + (f - Processor.E4));
                    break;
                case 2:
                    noteText.setText("B");
                    gapText.setText("" + (f - Processor.B3));
                    break;
                case 3:
                    noteText.setText("G");
                    gapText.setText("" + (f - Processor.G3));
                    break;
                case 4:
                    noteText.setText("D");
                    gapText.setText("" + (f - Processor.D3));
                    break;
                case 5:
                    noteText.setText("A");
                    gapText.setText("" + (f - Processor.A2));
                    break;
                case 6:
                    noteText.setText("Low E");
                    gapText.setText("" + (f - Processor.E2));
                    break;
                default:
                    double res = Processor.simpleProcessor(f);
                    if (res == Processor.E4)
                    {
                        noteText.setText("High E");
                        gapText.setText("" + (f - Processor.E4));
                    }
                    else if (res == Processor.B3)
                    {
                        noteText.setText("B");
                        gapText.setText("" + (f - Processor.B3));
                    }
                    else if (res == Processor.G3)
                    {
                        noteText.setText("G");
                        gapText.setText("" + (f - Processor.G3));
                    }
                    else if (res == Processor.D3)
                    {
                        noteText.setText("D");
                        gapText.setText("" + (f - Processor.D3));
                    }
                    else if (res == Processor.A2)
                    {
                        noteText.setText("A");
                        gapText.setText("" + (f - Processor.A2));
                    }
                    else
                    {
                        noteText.setText("Low E");
                        gapText.setText("" + (f - Processor.E2));
                    }
            }
        }
        else
        {
            double res = Processor.fullProcesor(f);
            double gap = -1;
            if (res == Processor.A0)
            {
                noteText.setText("A0");
                gap = f - Processor.A0;
            }
            else if (res == Processor.A_S_0)
            {
                noteText.setText("A0 Sharp");
                gap = f - Processor.A_S_1;
            }
            else if (res == Processor.B0)
            {
                noteText.setText("B0");
                gap = f - Processor.B0;
            }
            else if (res == Processor.C1)
            {
                noteText.setText("C1");
                gap = f - Processor.C1;
            }
            else if (res == Processor.C_S_1)
            {
                noteText.setText("C1 Sharp");
                gap = f - Processor.C_S_1;
            }
            else if (res == Processor.D1)
            {
                noteText.setText("D1");
                gap = f - Processor.D1;
            }
            else if (res == Processor.D_S_1)
            {
                noteText.setText("D1 Sharp");
                gap = f - Processor.D_S_1;
            }
            else if (res == Processor.E1)
            {
                noteText.setText("E1");
                gap = f - Processor.E1;
            }
            else if (res == Processor.F1)
            {
                noteText.setText("F1");
                gap = f - Processor.F1;
            }
            else if (res == Processor.F_S_1)
            {
                noteText.setText("F1 Sharp");
                gap = f - Processor.F_S_1;
            }
            else if (res == Processor.G1)
            {
                noteText.setText("G1");
                gap = f - Processor.G1;
            }
            else if (res == Processor.G_S_1)
            {
                noteText.setText("G1 Sharp");
                gap = f - Processor.G_S_1;
            }
            else if (res == Processor.A1)
            {
                noteText.setText("A1");
                gap = f - Processor.A1;
            }
            else if (res == Processor.A_S_1)
            {
                noteText.setText("A1 Sharp");
                gap = f - Processor.A_S_1;
            }
            else if (res == Processor.A_S_1)
            {
                noteText.setText("A1 Sharp");
                gap = f - Processor.A_S_1;
            }
            else if (res == Processor.B1)
            {
                noteText.setText("B1");
                gap = f - Processor.B1;
            }
            else if (res == Processor.C2)
            {
                noteText.setText("C2");
                gap = f - Processor.C2;
            }
            else if (res == Processor.C_S_2)
            {
                noteText.setText("C2 Sharp");
                gap = f - Processor.C_S_2;
            }
            else if (res == Processor.D2)
            {
                noteText.setText("D2");
                gap = f - Processor.D2;
            }
            else if (res == Processor.D_S_2)
            {
                noteText.setText("D2 Sharp");
                gap = f - Processor.D_S_2;
            }
            else if (res == Processor.E2)
            {
                noteText.setText("E2");
                gap = f - Processor.E2;
            }
            else if (res == Processor.F2)
            {
                noteText.setText("F2");
                gap = f - Processor.F2;
            }
            else if (res == Processor.F_S_2)
            {
                noteText.setText("F2 Sharp");
                gap = f - Processor.F_S_2;
            }
            else if (res == Processor.G2)
            {
                noteText.setText("G2");
                gap = f - Processor.G2;
            }
            else if (res == Processor.G_S_2)
            {
                noteText.setText("G2 Sharp");
                gap = f - Processor.G_S_2;
            }
            else if (res == Processor.A2)
            {
                noteText.setText("A2");
                gap = f - Processor.A2;
            }
            else if (res == Processor.A_S_2)
            {
                noteText.setText("A2 Sharp");
                gap = f - Processor.A_S_2;
            }
            else if (res == Processor.B2)
            {
                noteText.setText("B2");
                gap = f - Processor.B2;
            }
            else if (res == Processor.C3)
            {
                noteText.setText("C3");
                gap = f - Processor.C3;
            }
            else if (res == Processor.C_S_3)
            {
                noteText.setText("C3 Sharp");
                gap = f - Processor.C_S_3;
            }
            else if (res == Processor.D3)
            {
                noteText.setText("D3");
                gap = f - Processor.D3;
            }
            else if (res == Processor.D_S_3)
            {
                noteText.setText("D3 Sharp");
                gap = f - Processor.D_S_3;
            }
            else if (res == Processor.E3)
            {
                noteText.setText("E3");
                gap = f - Processor.E3;
            }
            else if (res == Processor.F3)
            {
                noteText.setText("F3");
                gap = f - Processor.F3;
            }
            else if (res == Processor.F_S_3)
            {
                noteText.setText("F3 Sharp");
                gap = f - Processor.F_S_3;
            }
            else if (res == Processor.G3)
            {
                noteText.setText("G3");
                gap = f - Processor.G3;
            }
            else if (res == Processor.G_S_3)
            {
                noteText.setText("G3 Sharp");
                gap = f - Processor.G_S_3;
            }
            else if (res == Processor.A3)
            {
                noteText.setText("A3");
                gap = f - Processor.A3;
            }
            else if (res == Processor.A_S_3)
            {
                noteText.setText("A3 Sharp");
                gap = f - Processor.A_S_3;
            }
            else if (res == Processor.B3)
            {
                noteText.setText("B3");
                gap = f - Processor.B3;
            }
            else if (res == Processor.C4)
            {
                noteText.setText("C4");
                gap = f - Processor.C4;
            }
            else if (res == Processor.C_S_4)
            {
                noteText.setText("C4 Sharp");
                gap = f - Processor.C_S_4;
            }
            else if (res == Processor.D4)
            {
                noteText.setText("D4");
                gap = f - Processor.D4;
            }
            else if (res == Processor.D_S_4)
            {
                noteText.setText("D4 Sharp");
                gap = f - Processor.D_S_4;
            }
            else if (res == Processor.E4)
            {
                noteText.setText("E4");
                gap = f - Processor.E4;
            }
            else if (res == Processor.F4)
            {
                noteText.setText("F4");
                gap = f - Processor.F4;
            }
            else if (res == Processor.F_S_4)
            {
                noteText.setText("F4 Sharp");
                gap = f - Processor.F_S_4;
            }
            else if (res == Processor.G4)
            {
                noteText.setText("G4");
                gap = f - Processor.G4;
            }
            else if (res == Processor.G_S_4)
            {
                noteText.setText("G4 Sharp");
                gap = f - Processor.G_S_4;
            }
            else if (res == Processor.A4)
            {
                noteText.setText("A4");
                gap = f - Processor.A4;
            }
            else if (res == Processor.A_S_4)
            {
                noteText.setText("A4 Sharp");
                gap = f - Processor.A_S_4;
            }
            else if (res == Processor.B4)
            {
                noteText.setText("B4");
                gap = f - Processor.B4;
            }
            else if (res == Processor.C5)
            {
                noteText.setText("C5");
                gap = f - Processor.C5;
            }
            else if (res == Processor.C_S_5)
            {
                noteText.setText("C5 Sharp");
                gap = f - Processor.C_S_5;
            }
            else if (res == Processor.D5)
            {
                noteText.setText("D5");
                gap = f - Processor.D5;
            }
            else if (res == Processor.D_S_5)
            {
                noteText.setText("D5 Sharp");
                gap = f - Processor.D_S_5;
            }
            else if (res == Processor.E5)
            {
                noteText.setText("E5");
                gap = f - Processor.E5;
            }
            else if (res == Processor.F5)
            {
                noteText.setText("F5");
                gap = f - Processor.F5;
            }
            else if (res == Processor.F_S_5)
            {
                noteText.setText("F5 Sharp");
                gap = f - Processor.F_S_5;
            }
            else if (res == Processor.G5)
            {
                noteText.setText("G5");
                gap = f - Processor.G5;
            }
            else if (res == Processor.G_S_5)
            {
                noteText.setText("G5 Sharp");
                gap = f - Processor.G_S_5;
            }
            else if (res == Processor.A5)
            {
                noteText.setText("A5");
                gap = f - Processor.A5;
            }
            else if (res == Processor.A_S_5)
            {
                noteText.setText("A5 Sharp");
                gap = f - Processor.A_S_5;
            }
            else if (res == Processor.B5)
            {
                noteText.setText("B5");
                gap = f - Processor.B5;
            }
            else if (res == Processor.C6)
            {
                noteText.setText("C6");
                gap = f - Processor.C6;
            }
            else if (res == Processor.C_S_6)
            {
                noteText.setText("C6 Sharp");
                gap = f - Processor.C_S_6;
            }
            else if (res == Processor.D6)
            {
                noteText.setText("D6");
                gap = f - Processor.D6;
            }
            else if (res == Processor.D_S_6)
            {
                noteText.setText("D6 Sharp");
                gap = f - Processor.D_S_6;
            }
            else if (res == Processor.E6)
            {
                noteText.setText("E6");
                gap = f - Processor.E6;
            }
            else if (res == Processor.F6)
            {
                noteText.setText("F6");
                gap = f - Processor.F6;
            }
            else if (res == Processor.F_S_6)
            {
                noteText.setText("F6 Sharp");
                gap = f - Processor.F_S_6;
            }
            else if (res == Processor.G6)
            {
                noteText.setText("G6");
                gap = f - Processor.G6;
            }
            else if (res == Processor.G_S_6)
            {
                noteText.setText("G6 Sharp");
                gap = f - Processor.G_S_6;
            }
            else if (res == Processor.A6)
            {
                noteText.setText("A6");
                gap = f - Processor.A6;
            }
            else if (res == Processor.A_S_6)
            {
                noteText.setText("A6 Sharp");
                gap = f - Processor.A_S_6;
            }
            else if (res == Processor.B6)
            {
                noteText.setText("B6");
                gap = f - Processor.B6;
            }
            else if (res == Processor.C7)
            {
                noteText.setText("C7");
                gap = f - Processor.C7;
            }
            else if (res == Processor.C_S_7)
            {
                noteText.setText("C7 Sharp");
                gap = f - Processor.C_S_7;
            }
            else if (res == Processor.D7)
            {
                noteText.setText("D7");
                gap = f - Processor.D7;
            }
            else if (res == Processor.D_S_7)
            {
                noteText.setText("D7 Sharp");
                gap = f - Processor.D_S_7;
            }
            else if (res == Processor.E7)
            {
                noteText.setText("E7");
                gap = f - Processor.E7;
            }
            else if (res == Processor.F7)
            {
                noteText.setText("F7");
                gap = f - Processor.F7;
            }
            else if (res == Processor.F_S_7)
            {
                noteText.setText("F7 Sharp");
                gap = f - Processor.F_S_7;
            }
            else if (res == Processor.G7)
            {
                noteText.setText("G7");
                gap = f - Processor.G7;
            }
            else if (res == Processor.G_S_7)
            {
                noteText.setText("G7 Sharp");
                gap = f - Processor.G_S_7;
            }
            else
            {
                noteText.setText(lastNote);
                gapText.setText(lastGap);
            }
            if (gap != -1)
            {
                lastNote = noteText.getText().toString();
                if (gap > 0) {
                    if (gap <= 0.004 * res || (-1 * gap) <= 0.004 * res) {
                        gapText.setText("Accurate");
                        lastGap = "Accurate";
                    } else if (gap <= 0.01 * res) {
                        gapText.setText("-1");
                        lastGap = "-1";
                    } else if (gap <= 0.02 * res) {
                        gapText.setText("-2");
                        lastGap = "-2";
                    } else if (gap <= 0.03 * res) {
                        gapText.setText("-3");
                        lastGap = "-3";
                    } else if (gap <= 0.04 * res) {
                        gapText.setText("-4");
                        lastGap = "-4";
                    } else if (gap <= 0.05 * res) {
                        gapText.setText("-5");
                        lastGap = "-5";
                    } else if (gap <= 0.06 * res) {
                        gapText.setText("-6");
                        lastGap = "-6";
                    } else if (gap <= res) {
                        gapText.setText("-7");
                        lastGap = "-7";
                    }  else {
                        gapText.setText("0");
                    }
                }
                else {
                    if ((-1 * gap) <= 0.004 * res) {
                        gapText.setText("Accurate");
                    } else if ((-1 * gap) <= 0.01 * res) {
                        gapText.setText("+1");
                        lastGap = "+1";
                    } else if ((-1 * gap) <= 0.02 * res) {
                        gapText.setText("+2");
                        lastGap = "+2";
                    } else if ((-1 * gap) <= 0.03 * res) {
                        gapText.setText("+3");
                        lastGap = "+3";
                    } else if ((-1 * gap) <= 0.04 * res) {
                        gapText.setText("+4");
                        lastGap = "+4";
                    } else if ((-1 * gap) <= 0.05 * res) {
                        gapText.setText("+5");
                        lastGap = "+5";
                    } else if ((-1 * gap) <= 0.06 * res) {
                        gapText.setText("+6");
                        lastGap = "+6";
                    } else if ((-1 * gap) <= res) {
                        gapText.setText("+7");
                        lastGap = "+7";
                    } else {
                        gapText.setText("0");
                    }
                }
            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
        {
            ((Button) findViewById(R.id.auto)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.string1)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.string2)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.string3)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.string4)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.string5)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.string6)).setVisibility(View.VISIBLE);
        }
        else
        {
            ((Button) findViewById(R.id.auto)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.string1)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.string2)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.string3)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.string4)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.string5)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.string6)).setVisibility(View.GONE);
        }
    }

}
