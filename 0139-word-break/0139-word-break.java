class Solution {
    public boolean fnCheck(String s,HashSet<String>hs,HashMap<String,Boolean>hm)
    {
        if(s.length()==0)
        {
            return true;
            
        }
        if(hm.containsKey(s))
            return hm.get(s);
        for(int i=0;i<s.length();i++)
        {
            if(hs.contains(s.substring(0,i+1)))
            {
                boolean k=fnCheck(s.substring(i+1),hs,hm);
                if(k==true)
                {
                    hm.put(s.substring(0,i+1),true);
                     return true;
                }
               
            }
          
        }
        hm.put(s,false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>hs=new HashSet<>();
        for(String st:wordDict)
            hs.add(st);
        HashMap<String ,Boolean>hm=new HashMap<>();
        return fnCheck(s,hs,hm);
    }
}
// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]