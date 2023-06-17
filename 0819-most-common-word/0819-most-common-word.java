class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashSet<String>hs=new HashSet<>();
        HashMap<String,Integer>hm=new HashMap<>();
        
        for(String s:banned)
            hs.add(s);
        for(String s:words)
            if(!hs.contains(s))
                hm.put(s,hm.getOrDefault(s,0)+1);
        
        String ans="";
        int max=0;
        for(String s:hm.keySet())
        {
            //System.out.println(s+" "+hm.get(s));
            int val=hm.get(s);
            if(val>max)
            {
                ans=s;
                max=val;
            }
        }
        return ans;
            
    }
}