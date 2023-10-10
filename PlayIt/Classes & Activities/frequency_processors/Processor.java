package application.playit.frequency_processors;

/**
 * Created by User on 30-Jan-18.
 */

public class Processor {

    public static final double A0 = 27.5;
    public static final double A_S_0 = 29.14;

    public static final double A1 = 55;
    public static final double A_S_1 = 58.27;

    public static final double A2 = 110;
    public static final double A_S_2 = 116.54;

    public static final double A3 = 220;
    public static final double A_S_3 = 233.08;

    public static final double A4 = 440;
    public static final double A_S_4 = 466.16;

    public static final double A5 = 880;
    public static final double A_S_5 = 932.33;

    public static final double A6 = 1760;
    public static final double A_S_6 = 1864.66;

    /*B notes constant*/

    public static final double B0 = 30.87;

    public static final double B1 = 61.74;

    public static final double B2 = 123.47;

    public static final double B3 = 246.94;

    public static final double B4 = 493.88;

    public static final double B5 = 987.77;

    public static final double B6 = 1975.53;

    /*C notes constants*/

    public static final double C1 = 32.70;
    public static final double C_S_1 = 34.65;

    public static final double C2 = 65.41;
    public static final double C_S_2 = 69.30;

    public static final double C3 = 130.81;
    public static final double C_S_3 = 138.59;

    public static final double C4 = 261.63;
    public static final double C_S_4 = 277.18;

    public static final double C5 = 523.25;
    public static final double C_S_5 = 554.37;

    public static final double C6 = 1046.50;
    public static final double C_S_6 = 1108.73;

    public static final double C7 = 2093.00;
    public static final double C_S_7 = 2217.46;

    /*D notes constants*/

    public static final double D1 = 36.71;
    public static final double D_S_1 = 38.89;

    public static final double D2 = 73.42;
    public static final double D_S_2 = 77.78;

    public static final double D3 = 146.83;
    public static final double D_S_3 = 155.56;

    public static final double D4 = 293.66;
    public static final double D_S_4 = 311.13;

    public static final double D5 = 587.33;
    public static final double D_S_5 = 622.25;

    public static final double D6 = 1174.66;
    public static final double D_S_6 = 1244.51;

    public static final double D7 = 2349.32;
    public static final double D_S_7 = 2489.02;

    /*E notes constants*/

    public static final double E1 = 41.20;

    public static final double E2 = 82.41;

    public static final double E3 = 164.81;

    public static final double E4 = 329.63;

    public static final double E5 = 659.25;

    public static final double E6 = 1318.51;

    public static final double E7 = 2637.02;

    /*F notes constants*/


    public static final double F1 = 43.65;
    public static final double F_S_1 = 46.25;

    public static final double F2 = 87.31;
    public static final double F_S_2 = 92.50;

    public static final double F3 = 174.61;
    public static final double F_S_3 = 185.00;

    public static final double F4 = 349.23;
    public static final double F_S_4 = 369.99;

    public static final double F5 = 698.46;
    public static final double F_S_5 = 739.99;

    public static final double F6 = 1396.91;
    public static final double F_S_6 = 1479.98;

    public static final double F7 = 2793.83;
    public static final double F_S_7 = 2959.96;

    /*G notes constants*/

    public static final double G1 = 49.00;
    public static final double G_S_1 = 51.91;

    public static final double G2 = 98.00;
    public static final double G_S_2 = 103.83;

    public static final double G3 = 196.00;
    public static final double G_S_3 = 207.65;

    public static final double G4 = 392.00;
    public static final double G_S_4 = 415.30;

    public static final double G5 = 783.99;
    public static final double G_S_5 = 830.61;

    public static final double G6 = 1567.98;
    public static final double G_S_6 = 1661.22;

    public static final double G7 = 3135.96;
    public static final double G_S_7 = 3322.44;

    public static double simpleProcessor(double f)
    {
        if (f < E2) {
            return E2;
        } else if (f >= E2 && f < A2) {
            if (f <= E2 + ((A2 - E2) / 2)) {
                return E2;
            } else {
                return A2;
            }
        } else if (f >= A2 && f < D3) {
            if (f <= A2 + ((D3 - A2) / 2)) {
                return A2;
            } else {
                return D3;
            }
        } else if (f >= D3 && f < G3) {
            if (f <= D3 + ((G3 - D3) / 2)) {
                return D3;
            } else {
                return G3;
            }
        } else if (f >= G3 && f < B3) {
            if (f <= G3 + ((B3 - G3) / 2)) {
                return G3;
            } else {
                return B3;
            }
        } else if (f >= B3 && f < E4) {
            if (f <= B3 + ((E4 - B3) / 2)) {
                return B3;
            } else {
                return E4;
            }
        } else {
            return E4;
        }
    }

    public static double guitarNotesProcessor(double f) {
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
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static double fullProcesor(double f)
    {
        if (f >= 0 && f < A0) {
            if (f > 18)
            {
                return A0;
            }
            else
            {
                return -1;
            }
    }
        else if (f >= A0 && f < A_S_0) {
        //E2
            if (f <= A0 + ((A_S_0 - A0) / 2)) {
                return A0;
            }
            //A#0
            else {
                return A_S_0;
            }
        }
        else if (f >= A_S_0 && f < B0) {
        //E2
            if (f <= A_S_0 + ((B0 - A_S_0) / 2)) {
                return A_S_0;
            }
            //A#0
            else {
                return B0;
            }
        }
        else if (f >= B0 && f < C1) {
        //E2
            if (f <= B0 + ((C1 - B0) / 2)) {
                return B0;
            }
            //A#0
            else {
                return C1;
            }
        }
        else if (f >= C1 && f < C_S_1) {
        //E2
            if (f <= C1 + ((C_S_1 - C1) / 2)) {
                return C1;
            }
            //A#0
            else {
                return C_S_1;
            }
        }
        else if (f >= C_S_1 && f < D1) {
        //E2
            if (f <= C_S_1 + ((D1 - C_S_1) / 2)) {
                return C_S_1;
            }
            //A#0
            else {
                return D1;
            }
        }
        else if (f >= D1 && f < D_S_1) {
        //E2
            if (f <= D1 + ((D_S_1 - D1) / 2)) {
                return D1;
            }
            //A#0
            else {
                return D_S_1;
            }
        }
        else if (f >= D_S_1 && f < E1) {
        //E2
            if (f <= D_S_1 + ((E1 - D_S_1) / 2)) {
                return D_S_1;
            }
            //A#0
            else {
                return E1;
            }
        }
        else if (f >= E1 && f < F1) {
        //E2
            if (f <= E1 + ((F1 - E1) / 2)) {
                return E1;
            }
            //A#0
            else {
                return F1;
            }
        }
        else if (f >= F1 && f < F_S_1) {
        //E2
            if (f <= F1 + ((F_S_1 - F1) / 2)) {
                return F1;
            }
            //A#0
            else {
                return F_S_1;
            }
        }
        else if (f >= F_S_1 && f < G1) {
        //E2
            if (f <= F_S_1 + ((G1 - F_S_1) / 2)) {
                return F_S_1;
            }
            //A#0
            else {
                return G1;
            }
        }
        else if (f >= G1 && f < G_S_1) {
        //E2
        if (f <= G1 + ((G_S_1 - G1) / 2)) {
            return G1;
        }
        //A#0
        else {
            return G_S_1;
        }
    }
        else if (f >= G_S_1 && f < A1) {
        //E2
            if (f <= G_S_1 + ((A1 - G_S_1) / 2)) {
                return G_S_1;
            }
            //A#0
            else {
                return A1;
            }
        }
        else if (f >= A1 && f < A_S_1) {
        //E2
            if (f <= A1 + ((A_S_1 - A1) / 2)) {
                return A1;
            }
            //A#0
            else {
                return A_S_1;
            }
        }
        else if (f >= A_S_1 && f < B1) {
        //E2
            if (f <= A_S_1 + ((B1 - A_S_1) / 2)) {
                return A_S_1;
            }
            //A#0
            else {
                return B1;
            }
        }
        else if (f >= B1 && f < C2) {
        //E2
            if (f <= B1 + ((C2 - B1) / 2)) {
                return B1;
            }
            //A#0
            else {
                return C2;
            }
        }
        else if (f >= C2 && f < C_S_2) {
        //E2
            if (f <= C2 + ((C_S_2 - C2) / 2)) {
                return C2;
            }
            //A#0
            else {
                return C_S_2;
            }
        }
        else if (f >= C_S_2 && f < D2) {
        //E2
            if (f <= C_S_2 + ((D2 - C_S_2) / 2)) {
                return C_S_2;
            }
            //A#0
            else {
                return D2;
            }
        }
        else if (f >= D2 && f < D_S_2) {
            //E2
            if (f <= D2 + ((D_S_2 - D2) / 2)) {
                return D2;
            }
            //A#0
            else {
                return D_S_2;
            }
        }
        else if (f >= D_S_2 && f < E2) {
            //E2
            if (f <= D_S_2 + ((E2 - D_S_2) / 2)) {
                return D_S_2;
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
                return F6;
            }
        } else if (f >= F6 && f < F_S_6) {
            if (f <= F6 + ((F_S_6 - F6) / 2)) {
                return F6;
            } else {
                return F_S_6;
            }
        }else if (f >= F_S_6 && f < G6) {
            if (f <= F_S_6 + ((G6 - F_S_6) / 2)) {
                return F_S_6;
            } else {
                return G6;
            }
        }else if (f >= G6 && f < G_S_6) {
            if (f <= G6 + ((G_S_6 - G6) / 2)) {
                return G6;
            } else {
                return G_S_6;
            }
        }
        else if (f >= G_S_6 && f < A6) {
            if (f <= G_S_6 + ((A6 - G_S_6) / 2)) {
                return G_S_6;
            } else {
                return A6;
            }
        }
        else if (f >= A6 && f < A_S_6) {
            if (f <= A6 + ((A_S_6 - A6) / 2)) {
                return A6;
            } else {
                return A_S_6;
            }
        }
        else if (f >= A_S_6 && f < B6) {
            if (f <= A_S_6 + ((B6 - A_S_6) / 2)) {
                return A_S_6;
            } else {
                return B6;
            }
        }
        else if (f >= B6 && f < C7) {
            if (f <= B6 + ((C7 - B6) / 2)) {
                return B6;
            } else {
                return C7;
            }
        }
        else if (f >= B6 && f < C7) {
            if (f <= B6 + ((C7 - B6) / 2)) {
                return B6;
            } else {
                return C7;
            }
        }
        else if (f >= C7 && f < C_S_7) {
            if (f <= C7 + ((C_S_7 - C7) / 2)) {
                return C7;
            } else {
                return C_S_7;
            }
        }
        else if (f >= C_S_7 && f < D7) {
            if (f <= C_S_7 + ((D7 - C_S_7) / 2)) {
                return C_S_7;
            } else {
                return D7;
            }
        }
        else if (f >= D7 && f < D_S_7) {
            if (f <= D7 + ((D_S_7 - D7) / 2)) {
                return D7;
            } else {
                return D_S_7;
            }
        }
        else if (f >= D_S_7 && f < E7) {
            if (f <= D_S_7 + ((E7 - D_S_7) / 2)) {
                return D_S_7;
            } else {
                return E7;
            }
        }
        else if (f >= E7 && f < F7) {
            if (f <= E7 + ((F7 - E7) / 2)) {
                return E7;
            } else {
                return F7;
            }
        }
        else if (f >= E7 && f < F7) {
            if (f <= E7 + ((F7 - E7) / 2)) {
                return E7;
            } else {
                return F7;
            }
        }
        else if (f >= F7 && f < F_S_7) {
            if (f <= F7 + ((F_S_7 - F7) / 2)) {
                return F7;
            } else {
                return F_S_7;
            }
        }
        else if (f >= F_S_7 && f < G7) {
            if (f <= F_S_7 + ((G7 - F_S_7) / 2)) {
                return F_S_7;
            } else {
                return G7;
            }
        }
        else if (f >= G7 && f < G_S_7) {
            if (f <= G7 + ((G_S_7 - G7) / 2)) {
                return G7;
            } else {
                return G_S_7;
            }
        }
        else if (f < G_S_7 + 100) {
            return G_S_7;
        }
        else {
            return -1;
        }
    }

    public static double guitarToFreq(int string, int fret)
    {
        if (string == 1 && fret == 24)
        {
            return E6;
        }
        else if (string == 1 && fret == 23)
        {
            return D_S_6;
        }
        else if (string == 1 && fret == 22)
        {
            return D6;
        }
        else if (string == 1 && fret == 21)
        {
            return C_S_6;
        }
        else if (string == 1 && fret == 20)
        {
            return C6;
        }
        else if ((string == 1 && fret == 19) || (string == 2 && fret == 24))
        {
            return B5;
        }
        else if ((string == 1 && fret == 18) || (string == 2 && fret == 23))
        {
            return A_S_5;
        }
        else if ((string == 1 && fret == 17) || (string == 2 && fret == 22))
        {
            return A5;
        }
        else if ((string == 1 && fret == 16) || (string == 2 && fret == 21))
        {
            return G_S_5;
        }
        else if ((string == 1 && fret == 15) || (string == 2 && fret == 20) || (string == 3 && fret == 24))
        {
            return G5;
        }
        else if ((string == 1 && fret == 14) || (string == 2 && fret == 19) || (string == 3 && fret == 23))
        {
            return F_S_5;
        }
        else if ((string == 1 && fret == 13) || (string == 2 && fret == 18) || (string == 3 && fret == 22))
        {
            return F5;
        }
        else if ((string == 1 && fret == 12) || (string == 2 && fret == 17) || (string == 3 && fret == 21))
        {
            return E5;
        }
        else if ((string == 1 && fret == 11) || (string == 2 && fret == 16) || (string == 3 && fret == 20))
        {
            return D_S_5;
        }
        else if ((string == 1 && fret == 10) || (string == 2 && fret == 15) || (string == 3 && fret == 19) || (string == 4 && fret == 24))
        {
            return D5;
        }
        else if ((string == 1 && fret == 9) || (string == 2 && fret == 14) || (string == 3 && fret == 18) || (string == 4 && fret == 23))
        {
            return C_S_5;
        }
        else if ((string == 1 && fret == 8) || (string == 2 && fret == 13) || (string == 3 && fret == 17) || (string == 4 && fret == 22))
        {
            return C5;
        }
        else if ((string == 1 && fret == 7) || (string == 2 && fret == 12) || (string == 3 && fret == 16) || (string == 4 && fret == 21))
        {
            return B4;
        }
        else if ((string == 1 && fret == 6) || (string == 2 && fret == 11) || (string == 3 && fret == 15) || (string == 4 && fret == 20))
        {
            return A_S_4;
        }
        else if ((string == 1 && fret == 5) || (string == 2 && fret == 10) || (string == 3 && fret == 14) || (string == 4 && fret == 19) || (string == 5 && fret == 24))
        {
            return A4;
        }
        else if ((string == 1 && fret == 4) || (string == 2 && fret == 9) || (string == 3 && fret == 13) || (string == 4 && fret == 18) || (string == 5 && fret == 23))
        {
            return G_S_4;
        }
        else if ((string == 1 && fret == 3) || (string == 2 && fret == 8) || (string == 3 && fret == 12) || (string == 4 && fret == 17) || (string == 5 && fret == 22))
        {
            return G4;
        }
        else if ((string == 1 && fret == 2) || (string == 2 && fret == 7) || (string == 3 && fret == 11) || (string == 4 && fret == 16) || (string == 5 && fret == 21))
        {
            return F_S_4;
        }
        else if ((string == 1 && fret == 1) || (string == 2 && fret == 6) || (string == 3 && fret == 10) || (string == 4 && fret == 15) || (string == 5 && fret == 20))
        {
            return F4;
        }
        else if ((string == 1 && fret == 0) || (string == 2 && fret == 5) || (string == 3 && fret == 9) || (string == 4 && fret == 14) || (string == 5 && fret == 19) || (string == 6 && fret == 24))
        {
            return E4;
        }
        else if ((string == 2 && fret == 4) || (string == 3 && fret == 8) || (string == 4 && fret == 13) || (string == 5 && fret == 18) || (string == 6 && fret == 23))
        {
            return D_S_4;
        }
        else if ((string == 2 && fret == 3) || (string == 3 && fret == 7) || (string == 4 && fret == 12) || (string == 5 && fret == 17) || (string == 6 && fret == 22))
        {
            return D4;
        }
        else if ((string == 2 && fret == 2) || (string == 3 && fret == 6) || (string == 4 && fret == 11) || (string == 5 && fret == 16) || (string == 6 && fret == 21))
        {
            return C_S_4;
        }
        else if ((string == 2 && fret == 1) || (string == 3 && fret == 5) || (string == 4 && fret == 10) || (string == 5 && fret == 15) || (string == 6 && fret == 20))
        {
            return C4;
        }
        else if ((string == 2 && fret == 0) || (string == 3 && fret == 4) || (string == 4 && fret == 9) || (string == 5 && fret == 14) || (string == 6 && fret == 19))
        {
            return B3;
        }
        else if ((string == 3 && fret == 3) || (string == 4 && fret == 8) || (string == 5 && fret == 13) || (string == 6 && fret == 18))
        {
            return A_S_3;
        }
        else if ((string == 3 && fret == 2) || (string == 4 && fret == 7) || (string == 5 && fret == 12) || (string == 6 && fret == 17))
        {
            return A3;
        }
        else if ((string == 3 && fret == 1) || (string == 4 && fret == 6) || (string == 5 && fret == 11) || (string == 6 && fret == 16))
        {
            return G_S_3;
        }
        else if ((string == 3 && fret == 0) || (string == 4 && fret == 5) || (string == 5 && fret == 10) || (string == 6 && fret == 15))
        {
            return G3;
        }
        else if ((string == 4 && fret == 4) || (string == 5 && fret == 9) || (string == 6 && fret == 14))
        {
            return F_S_3;
        }
        else if ((string == 4 && fret == 3) || (string == 5 && fret == 8) || (string == 6 && fret == 13))
        {
            return F3;
        }
        else if ((string == 4 && fret == 2) || (string == 5 && fret == 7) || (string == 6 && fret == 12))
        {
            return E3;
        }
        else if ((string == 4 && fret == 1) || (string == 5 && fret == 6) || (string == 6 && fret == 11))
        {
            return D_S_3;
        }
        else if ((string == 4 && fret == 0) || (string == 5 && fret == 5) || (string == 6 && fret == 10))
        {
            return D3;
        }
        else if ((string == 5 && fret == 4) || (string == 6 && fret == 9))
        {
            return C_S_3;
        }
        else if ((string == 5 && fret == 3) || (string == 6 && fret == 8))
        {
            return C3;
        }
        else if ((string == 5 && fret == 2) || (string == 6 && fret == 7))
        {
            return B2;
        }
        else if ((string == 5 && fret == 1) || (string == 6 && fret == 6))
        {
            return A_S_2;
        }
        else if ((string == 5 && fret == 0) || (string == 6 && fret == 5))
        {
            return A2;
        }
        else if (string == 6 && fret == 4)
        {
            return G_S_2;
        }
        else if (string == 6 && fret == 3)
        {
            return G2;
        }
        else if (string == 6 && fret == 2)
        {
            return F_S_2;
        }
        else if (string == 6 && fret == 1)
        {
            return F2;
        }
        else
        {
            return E2;
        }
    }
}
