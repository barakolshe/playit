package Helpers.frequencyfunctions;
/**
 * Created by User on 03-Jan-18.
 */

public class Note {

    private static final double A2 = 110;
    private static final double A_S_2 = 116.54;

    private static final double A3 = 220;
    private static final double A_S_3 = 233.08;

    private static final double A4 = 440;
    private static final double A_S_4 = 466.16;

    private static final double A5 = 880;
    private static final double A_S_5 = 932.33;

    /*B notes constant*/

    private static final double B2 = 123.47;

    private static final double B3 = 246.94;

    private static final double B4 = 493.88;

    private static final double B5 = 987.77;

    /*C notes constants*/

    private static final double C3 = 130.81;
    private static final double C_S_3 = 138.59;

    private static final double C4 = 261.63;
    private static final double C_S_4 = 277.18;

    private static final double C5 = 523.25;
    private static final double C_S_5 = 554.37;

    private static final double C6 = 1046.50;
    private static final double C_S_6 = 1108.73;

    /*D notes constants*/

    private static final double D_S_2 = 77.78;

    private static final double D3 = 146.83;
    private static final double D_S_3 = 155.56;

    private static final double D4 = 293.66;
    private static final double D_S_4 = 311.13;

    private static final double D5 = 587.33;
    private static final double D_S_5 = 622.25;

    private static final double D6 = 1174.66;
    private static final double D_S_6 = 1244.51;

    /*E notes constants*/

    private static final double E1 = 41.20;

    private static final double E2 = 82.41;

    private static final double E3 = 164.81;

    private static final double E4 = 329.63;

    private static final double E5 = 659.25;

    private static final double E6 = 1318.51;



    /*F notes constants*/

    private static final double F2 = 87.31;
    private static final double F_S_2 = 92.50;

    private static final double F3 = 174.61;
    private static final double F_S_3 = 185.00;

    private static final double F4 = 349.23;
    private static final double F_S_4 = 369.99;

    private static final double F5 = 698.46;
    private static final double F_S_5 = 739.99;

    private static final double F6 = 1396.91;

    /*G notes constants*/

    private static final double G2 = 98.00;
    private static final double G_S_2 = 103.83;

    private static final double G3 = 196.00;
    private static final double G_S_3 = 207.65;

    private static final double G4 = 392.00;
    private static final double G_S_4 = 415.30;

    private static final double G5 = 783.99;
    private static final double G_S_5 = 830.61;


    public static double frequencyToNote(float f) {
        if (f >= D_S_2 && f < E2) {
            //E2
            if (f <= D_S_2 + ((E2 - D_S_2) / 2)) {
                return 0;
            }
            //A#0
            else {
                return E2;
            }
        } else if (f >= E2 && f < F2) {
            //E2
            if (f <= E2 + ((F2 - E2) / 2)) {
                return E2;
            }
            //A#0
            else {
                return F2;
            }
        } else if (f >= F2 && f < F_S_2) {
            //F2
            if (f <= F2 + ((F_S_2 - F2) / 2)) {
                return F2;
            }
            //A#0
            else {
                return F_S_2;
            }
        } else if (f >= F_S_2 && f < G2) {
            //F_S_2
            if (f <= F_S_2 + ((G2 - F_S_2) / 2)) {
                return F_S_2;
            }
            //A#0
            else {
                return G2;
            }
        } else if (f >= G2 && f < G_S_2) {
            //G2
            if (f <= G2 + ((G_S_2 - G2) / 2)) {
                return G2;
            }
            //A#0
            else {
                return G_S_2;
            }
        } else if (f >= G_S_2 && f < A2) {
            //G_S_2
            if (f <= G_S_2 + ((A2 - G_S_2) / 2)) {
                return G_S_2;
            }
            //A#0
            else {
                return A2;
            }
        } else if (f >= A2 && f < A_S_2) {
            //A2
            if (f <= A2 + ((A_S_2 - A2) / 2)) {
                return A2;
            }
            //A#0
            else {
                return A_S_2;
            }
        } else if (f >= A_S_2 && f < B2) {
            //A_S_2
            if (f <= A_S_2 + ((B2 - A_S_2) / 2)) {
                return A_S_2;
            }
            //A#0
            else {
                return B2;
            }
        } else if (f >= B2 && f < C3) {
            //B2
            if (f <= B2 + ((C3 - B2) / 2)) {
                return B2;
            }
            //A#0
            else {
                return C3;
            }
        } else if (f >= C3 && f < C_S_3) {
            //C3
            if (f <= C3 + ((C_S_3 - C3) / 2)) {
                return C3;
            }
            //A#0
            else {
                return C_S_3;
            }
        } else if (f >= C_S_3 && f < D3) {
            //C_S_3
            if (f <= C_S_3 + ((D3 - C_S_3) / 2)) {
                return C_S_3;
            }
            //A#0
            else {
                return D3;
            }
        } else if (f >= D3 && f < D_S_3) {
            //D3
            if (f <= D3 + ((D_S_3 - D3) / 2)) {
                return D3;
            }
            //A#0
            else {
                return D_S_3;
            }
        } else if (f >= D_S_3 && f < E3) {
            //D_S_3
            if (f <= D_S_3 + ((E3 - D_S_3) / 2)) {
                return D_S_3;
            }
            //A#0
            else {
                return E3;
            }
        } else if (f >= E3 && f < F3) {
            //E3
            if (f <= E3 + ((F3 - E3) / 2)) {
                return E3;
            }
            //A#0
            else {
                return F3;
            }
        } else if (f >= F3 && f < F_S_3) {
            //F3
            if (f <= F3 + ((F_S_3 - F3) / 2)) {
                return F3;
            }
            //A#0
            else {
                return F_S_3;
            }
        } else if (f >= F_S_3 && f < G3) {
            //F_S_3
            if (f <= F_S_3 + ((G3 - F_S_3) / 2)) {
                return F_S_3;
            }
            //A#0
            else {
                return G3;
            }
        } else if (f >= G3 && f < G_S_3) {
            //G3
            if (f <= G3 + ((G_S_3 - G3) / 2)) {
                return G3;
            }
            //A#0
            else {
                return G_S_3;
            }
        } else if (f >= G_S_3 && f < A3) {
            //G_S_3
            if (f <= G_S_3 + ((A3 - G_S_3) / 2)) {
                return G_S_3;
            }
            //A#0
            else {
                return A3;
            }
        } else if (f >= A3 && f < A_S_3) {
            //A3
            if (f <= A3 + ((A_S_3 - A3) / 2)) {
                return A3;
            }
            //A#0
            else {
                return A_S_3;
            }
        } else if (f >= A_S_3 && f < B3) {
            //A_S_3
            if (f <= A_S_3 + ((B3 - A_S_3) / 2)) {
                return A_S_3;
            }
            //A#0
            else {
                return B3;
            }
        } else if (f >= B3 && f < C4) {
            //B3
            if (f <= B3 + ((C4 - B3) / 2)) {
                return B3;
            }
            //A#0
            else {
                return C4;
            }
        } else if (f >= C4 && f < C_S_4) {
            //C4
            if (f <= C4 + ((C_S_4 - C4) / 2)) {
                return C4;
            }
            //A#0
            else {
                return C_S_4;
            }
        } else if (f >= C_S_4 && f < D4) {
            //C_S_4
            if (f <= C_S_4 + ((D4 - C_S_4) / 2)) {
                return C_S_4;
            }
            //A#0
            else {
                return D4;
            }
        } else if (f >= D4 && f < D_S_4) {
            //D4
            if (f <= D4 + ((D_S_4 - D4) / 2)) {
                return D4;
            }
            //A#0
            else {
                return D_S_4;
            }
        } else if (f >= D_S_4 && f < E4) {
            //D_S_4
            if (f <= D_S_4 + ((E4 - D_S_4) / 2)) {
                return D_S_4;
            }
            //A#0
            else {
                return E4;
            }
        } else if (f >= E4 && f < F4) {
            //E4
            if (f <= E4 + ((F4 - E4) / 2)) {
                return E4;
            }
            //A#0
            else {
                return F4;
            }
        } else if (f >= F4 && f < F_S_4) {
            //F4
            if (f <= F4 + ((F_S_4 - F4) / 2)) {
                return F4;
            }
            //A#0
            else {
                return F_S_4;
            }
        } else if (f >= F_S_4 && f < G4) {
            //F_S_4
            if (f <= F_S_4 + ((G4 - F_S_4) / 2)) {
                return F_S_4;
            }
            //A#0
            else {
                return G4;
            }
        } else if (f >= G4 && f < G_S_4) {
            //G4
            if (f <= G4 + ((G_S_4 - G4) / 2)) {
                return G4;
            }
            //A#0
            else {
                return G_S_4;
            }
        } else if (f >= G_S_4 && f < A4) {
            //G_S_4
            if (f <= G_S_4 + ((A4 - G_S_4) / 2)) {
                return G_S_4;
            }
            //A#0
            else {
                return A4;
            }
        } else if (f >= A4 && f < A_S_4) {
            //A4
            if (f <= A4 + ((A_S_4 - A4) / 2)) {
                return A4;
            }
            //A#0
            else {
                return A_S_4;
            }
        } else if (f >= A_S_4 && f < B4) {
            //A_S_4
            if (f <= A_S_4 + ((B4 - A_S_4) / 2)) {
                return A_S_4;
            }
            //A#0
            else {
                return B4;
            }
        } else if (f >= B4 && f < C5) {
            //B4
            if (f <= B4 + ((C5 - B4) / 2)) {
                return B4;
            }
            //A#0
            else {
                return C5;
            }
        } else if (f >= C5 && f < C_S_5) {
            //C5
            if (f <= C5 + ((C_S_5 - C5) / 2)) {
                return C5;
            }
            //A#0
            else {
                return C_S_5;
            }
        } else if (f >= C_S_5 && f < D5) {
            //C_S_5
            if (f <= C_S_5 + ((D5 - C_S_5) / 2)) {
                return C_S_5;
            }
            //A#0
            else {
                return D5;
            }
        } else if (f >= D5 && f < D_S_5) {
            //D5
            if (f <= D5 + ((D_S_5 - D5) / 2)) {
                return D5;
            }
            //A#0
            else {
                return D_S_5;
            }
        } else if (f >= D_S_5 && f < E5) {
            //D_S_5
            if (f <= D_S_5 + ((E5 - D_S_5) / 2)) {
                return D_S_5;
            }
            //A#0
            else {
                return E5;
            }
        } else if (f >= E5 && f < F5) {
            //E5
            if (f <= E5 + ((F5 - E5) / 2)) {
                return E5;
            }
            //A#0
            else {
                return F5;
            }
        } else if (f >= F5 && f < F_S_5) {
            //F5
            if (f <= F5 + ((F_S_5 - F5) / 2)) {
                return F5;
            }
            //A#0
            else {
                return F_S_5;
            }
        } else if (f >= F_S_5 && f < G5) {
            //F_S_5
            if (f <= F_S_5 + ((G5 - F_S_5) / 2)) {
                return F_S_5;
            }
            //A#0
            else {
                return G5;
            }
        } else if (f >= G5 && f < G_S_5) {
            //G5
            if (f <= G5 + ((G_S_5 - G5) / 2)) {
                return G5;
            }
            //A#0
            else {
                return G_S_5;
            }
        } else if (f >= G_S_5 && f < A5) {
            //G_S_5
            if (f <= G_S_5 + ((A5 - G_S_5) / 2)) {
                return G_S_5;
            }
            //A#0
            else {
                return A5;
            }
        } else if (f >= A5 && f < A_S_5) {
            //A5
            if (f <= A5 + ((A_S_5 - A5) / 2)) {
                return A5;
            }
            //A#0
            else {
                return A_S_5;
            }
        } else if (f >= A_S_5 && f < B5) {
            //A_S_5
            if (f <= A_S_5 + ((B5 - A_S_5) / 2)) {
                return A_S_5;
            }
            //A#0
            else {
                return B5;
            }
        } else if (f >= B5 && f < C6) {
            //B5
            if (f <= B5 + ((C6 - B5) / 2)) {
                return B5;
            }
            //A#0
            else {
                return C6;
            }
        } else if (f >= C6 && f < C_S_6) {
            //C6
            if (f <= C6 + ((C_S_6 - C6) / 2)) {
                return C6;
            }
            //A#0
            else {
                return C_S_6;
            }
        } else if (f >= C_S_6 && f < D6) {
            //C_S_6
            if (f <= C_S_6 + ((D6 - C_S_6) / 2)) {
                return C_S_6;
            }
            //A#0
            else {
                return D6;
            }
        } else if (f >= D6 && f < D_S_6) {
            //D6
            if (f <= D6 + ((D_S_6 - D6) / 2)) {
                return D6;
            }
            //A#0
            else {
                return D_S_6;
            }
        } else if (f >= D_S_6 && f < E6) {
            //D_S_6
            if (f <= D_S_6 + ((E6 - D_S_6) / 2)) {
                return D_S_6;
            }
            //A#0
            else {
                return E6;
            }
        } else if (f >= E6 && f < F6) {
            //E6
            if (f <= E6 + ((F6 - E6) / 2)) {
                return E6;
            }
            //A#0
            else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}

