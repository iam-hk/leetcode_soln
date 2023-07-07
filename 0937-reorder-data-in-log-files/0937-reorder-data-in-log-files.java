import java.util.*;
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digi = new ArrayList<>();
        List<String> word = new ArrayList<>();
        for(String s:logs)
        {
            if(Character.isDigit(s.charAt(s.length()-1)))
                digi.add(s);
            else
                word.add(s);
        }
        
        Collections.sort(word, new Comparator<String>()
        {
            public int compare(String s1, String s2)
            {
                int firstSpacePosition = s1.indexOf(" ");
                String firstWord = s1.substring(firstSpacePosition, s1.length());
                int secondSpacePosition = s2.indexOf(" ");
                String secondWord = s2.substring(secondSpacePosition, s2.length());
                
                if(firstWord.compareTo(secondWord) == 0)
                {
                    int firstSpacePosition1 = s1.indexOf(" ");
                    String firstWord1 = s1.substring(0, firstSpacePosition1);
                    int secondSpacePosition1 = s2.indexOf(" ");
                    String secondWord1 = s2.substring(0, secondSpacePosition1);
                    return firstWord1.compareTo(secondWord1);
                }

                return firstWord.compareTo(secondWord);
            }
        });

        String result[] = new String[digi.size() + word.size()];
        int in = 0;

        for(String s:word)
            result[in++] = s;

        for(String s:digi)
            result[in++] = s;

        return result;
    }
}