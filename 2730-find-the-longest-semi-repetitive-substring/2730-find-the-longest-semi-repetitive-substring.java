class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        if(s.length()==1)
            return 1;
        int st=0,e=s.length(),prev=0,count=0,ans=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)==s.charAt(i))
            {
                ++count;
               

            if(count==2)
            {
                st=prev;
                --count;
            }
            prev=i;
                
            }
            ans=Math.max(ans,i-st+1);
        }
        return ans;
    }
}