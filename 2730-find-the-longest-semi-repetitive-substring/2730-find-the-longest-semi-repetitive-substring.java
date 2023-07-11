class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        if(s.length()==1)
            return 1;
        int count=0,ans=0,prev=0,start=0;
        for(int i=1;i<s.length();i++)
        {
            char ch=s.charAt(i);
            char ch1=s.charAt(i-1);
            if(ch==ch1)
            {
                ++count;
                if(count==2)
                {
                    start=prev;
                    count=1;
                    ans=Math.max(ans,i-start+1);
                    prev=i;
                }
                prev=i;
                
            }
            ans=Math.max(ans,i-start+1);
            
        }
        return ans;
    }
}