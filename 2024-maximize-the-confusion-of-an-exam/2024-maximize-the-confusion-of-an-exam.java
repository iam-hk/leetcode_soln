class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int start=0,end=0,ans=0,count=0,n=s.length();
        while(end<n)
        {
            char ch=s.charAt(end);
            if(ch=='T')
                ++count;
            while(count>k)
                if(s.charAt(start++)=='T')
                    --count;
            ans=Math.max(ans,end-start+1);
            ++end;
        }
        end=0;
        start=0;
        count=0;
        while(end<n)
        {
            char ch=s.charAt(end);
            if(ch=='F')
                ++count;
            while(count>k)
                if(s.charAt(start++)=='F')
                    --count;
            ans=Math.max(ans,end-start+1);
            ++end;
        }
        return ans;
    }
}