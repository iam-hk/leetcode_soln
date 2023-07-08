class Solution {
    List<String>ans=new ArrayList<>();
    void fnGenerate(String s,int open ,int close)
    {
        if(open==close&&open==0)
        {
            ans.add(s);
            return;
        }
        if(open>0)
        {
            s+='(';
            fnGenerate(s,open-1,close);
            s=s.substring(0,s.length()-1);
        }
        if(close>0&&close>open)
        {
            s+=')';
            fnGenerate(s,open,close-1);
            s=s.substring(0,s.length()-1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        fnGenerate("",n,n);
        return ans;
    }
}