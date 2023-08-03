class Solution {
    public void fnCombination(String dig,int ind,String tmp,List<String>ans,HashMap<Integer,String>hm)
    {
        if(ind==dig.length())
        {
            ans.add(tmp);
            return;
        }
        int digit=dig.charAt(ind)-'0';
        String s=hm.get(digit);
        for(int i=0;i<s.length();i++)
        {
            tmp+=s.charAt(i);
            fnCombination(dig,ind+1,tmp,ans,hm);
            tmp=tmp.substring(0,tmp.length()-1);
        }

        }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String>hm=new HashMap<>();
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
        List<String>ans=new ArrayList<>();
        if(digits.length()==0)
            return ans;
        fnCombination(digits,0,"",ans,hm);
        return ans;
    }
}