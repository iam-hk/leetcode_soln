class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        char ch=s.charAt(0);
        int count=0,start=0;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            char cur=s.charAt(i);
            if(cur==ch)
            {
                ++count;
            }
            else 
            {
                if(count>=3)
                {
                    List<Integer>l=new ArrayList<>();
                    l.add(start);
                    l.add(i-1);
                    ans.add(l);
                    
                }
                ch=cur;
                start=i;
                count=1;
            }
        }
        if(count>=3)
        {
             List<Integer>l=new ArrayList<>();
                    l.add(start);
                    l.add(s.length()-1);
                    ans.add(l);
        }
        return ans;
    }
}