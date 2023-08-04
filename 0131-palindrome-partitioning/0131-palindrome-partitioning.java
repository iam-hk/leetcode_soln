class Solution {
    public void fnPart(String s,List<List<String>>ans,List<String>st,int n)
    {
        if(s.length()==0)
        {
            ans.add(new ArrayList<>(st));
            return ;
        }
        for(int i=0;i<s.length();i++)
        {
            String tmp=s.substring(0,i+1);
            if(fnCheck(tmp))
            {
                st.add(tmp);
                fnPart(s.substring(i+1),ans,st,n);
                st.remove(st.size()-1);
            }
        }
    }
    public boolean fnCheck(String s)
    {
      String tmp="";
      for(int i=s.length()-1;i>=0;i--)
      tmp+=s.charAt(i);
      if(tmp.equals(s))
      return true;
      return false;
    }
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>st=new ArrayList<>();
        fnPart(s,ans,st,s.length());
        return ans;
    }
}