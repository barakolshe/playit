package Helpers.tabsparsing;

import Helpers.frequencyfunctions.GuitarFrequencies;

//returning the next played note
public class tabsParser {

    private String[] tabs = new String[]{"","","","","",""};
    private int index = -1;

    public tabsParser(String originalTabs)
    {
        moduleTabs(originalTabs);
    }

    /*returning the frequency of the next note to be played.
    returns 0 on silent parts.
    returns -1 when the tabs have ended.
    */
    public double getNextNote()
    {
        short j = 0;
        int len = tabs[0].length();
        index++;
        while(index < len)
        {
            for(j = 0; j < 6;j++)
            {
                if(tabs[j].charAt(index) != '-')
                {
                    return GuitarFrequencies.getFrequency(j + 1, Character.getNumericValue(tabs[j].charAt(index)));
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
        String[] AllLines = originalTabs.split("\n");
        int i = 0, j = 0;
        String currString;
        for (i=0;i<6;i++)
        {
            tabs[i] = tabs[i].concat("-------------");
        }
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
        for (i=0;i<6;i++)
        {
            tabs[i] = tabs[i].replace("|", "");
        }
    }

    public String getString(short stringNum)
    {
        return tabs[stringNum];
    }
}
