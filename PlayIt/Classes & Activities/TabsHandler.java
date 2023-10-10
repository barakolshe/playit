package application.playit;

/**
 * Created by User on 30-Jan-18.
 */

import application.playit.frequency_processors.Processor;

public class TabsHandler {
    private String[] tabs = new String[]{"","","","","",""};
    private int _index = -1;
    private short _string = 0;
    private char _note;

    public TabsHandler(String originalTabs)
    {
        moduleTabs(originalTabs);
    }

    /*returning the frequency of the next note to be played.
    returns 0 on silent parts.
    returns -1 when the tabs have ended.
    */
    public double getNextNote()
    {
        return Processor.guitarToFreq(_string + 1, Character.getNumericValue(_note));
    }

    public char getNextNoteChar()
    {
        _note = tabs[_string].charAt(_index);
        return _note;
    }

    public int getString()
    {
        short j = 0;
        int len = tabs[0].length();
        _index++;

        if (_index < len)
        {
            for(j = 0; j < 6;j++)
            {
                if(tabs[j].charAt(_index) != '-')
                {
                    _string = j;
                    return j + 1;
                }
            }
            return 0;
        }
        return -1;
    }


    /*Splitting the tabs by enters, and then putting all the tabs into
    six strings that represent each string.
    */
    private void moduleTabs(String originalTabs)
    {
        String tmpString = originalTabs.replace("|", "");
        tmpString = tmpString.replace("e", "");
        tmpString = tmpString.replace("B", "");
        tmpString = tmpString.replace("G", "");
        tmpString = tmpString.replace("D", "");
        tmpString = tmpString.replace("A", "");
        tmpString = tmpString.replace("E", "");

        String[] AllLines = tmpString.split("\n");
        int i = 0, j = 0;
        String currString;

        for (i=0;i < AllLines.length; i++)
        {
            currString = AllLines[i];
            switch(j)
            {
                case 0:
                    tabs[0] = tabs[0].concat(currString.substring(2, currString.length() - 2));
                    break;
                case 1:
                    tabs[1] = tabs[1].concat(currString.substring(2, currString.length() - 2));
                    break;
                case 2:
                    tabs[2] = tabs[2].concat(currString.substring(2, currString.length() - 2));
                    break;
                case 3:
                    tabs[3] = tabs[3].concat(currString.substring(2, currString.length() - 2));
                    break;
                case 4:
                    tabs[4] = tabs[4].concat(currString.substring(2, currString.length() - 2));
                    break;
                default:
                    tabs[5] = tabs[5].concat(currString.substring(2, currString.length() - 2));
                    j = -1;
            }
            j++;
        }
    }
}
