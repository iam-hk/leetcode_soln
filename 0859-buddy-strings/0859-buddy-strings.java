class Solution {
    public boolean buddyStrings(String s, String goal) {
        int len=s.length(),len2=goal.length();
        if(len!=len2)
        return false;
        int count=0,ind1=-1,ind2=-1;
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            char ch1=goal.charAt(i);
            arr[ch-'a']++;
            if(ch!=ch1)
            {
                if(count==0)
                {
                    ind1=i;
                }
                else if(count==1)
                ind2=i;
                ++count;
            }

        }
        if(count>2)
        return false;
        if(count==1)
        return false;
        if(count ==0)
        {
            for(int i=0;i<26;i++)
            if(arr[i]>1)
            return true;
            return false;
        }
        if(s.charAt(ind1)==goal.charAt(ind2)&&s.charAt(ind2)==goal.charAt(ind1))
        return true;
        return false;
    }
}