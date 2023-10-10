package Helpers.frequencyfunctions;
/**
 * Created by User on 03-Jan-18.
 */

public class GuitarFrequencies {

    private static final double A2 = 110;
    private static final double A_S_2 = 116.54;

    private static final double B2 = 123.47;

    private static final double E2 = 82.41;

    private static final double F2 = 87.31;
    private static final double F_S_2 = 92.50;

    private static final double G2 = 98.00;
    private static final double G_S_2 = 103.83;

    private static final double A3 = 220;
    private static final double A_S_3 = 233.08;

    private static final double B3 = 246.94;

    private static final double C3 = 130.81;
    private static final double C_S_3 = 138.59;

    private static final double D3 = 146.83;
    private static final double D_S_3 = 155.56;

    private static final double E3 = 164.81;

    private static final double F3 = 174.61;
    private static final double F_S_3 = 185.00;

    private static final double G3 = 196.00;
    private static final double G_S_3 = 207.65;

    private static final double A4 = 440;
    private static final double A_S_4 = 466.16;

    private static final double B4 = 493.88;

    private static final double C4 = 261.63;
    private static final double C_S_4 = 277.18;

    private static final double D4 = 293.66;
    private static final double D_S_4 = 311.13;

    private static final double E4 = 329.63;

    private static final double F4 = 349.23;
    private static final double F_S_4 = 369.99;

    private static final double G4 = 392.00;
    private static final double G_S_4 = 415.30;

    private static final double A5 = 880;
    private static final double A_S_5 = 932.33;

    private static final double B5 = 987.77;

    private static final double C5 = 523.25;
    private static final double C_S_5 = 554.37;

    private static final double D5 = 587.33;
    private static final double D_S_5 = 622.25;

    private static final double E5 = 659.25;

    private static final double F5 = 698.46;
    private static final double F_S_5 = 739.99;

    private static final double G5 = 783.99;
    private static final double G_S_5 = 830.61;

    private static final double A6 = 1760;
    private static final double A_S_6 = 1864.66;

    private static final double B6 = 1975.53;

    private static final double C6 = 1046.50;
    private static final double C_S_6 = 1108.73;

    private static final double D6 = 1174.66;
    private static final double D_S_6 = 1244.51;

    private static final double E6 = 1318.51;

    public static double getFrequency(int string, int fret)
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
