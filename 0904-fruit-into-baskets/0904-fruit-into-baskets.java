class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int ans=0;
        int end=0,start=0;
        while(end<fruits.length)
        {
            hm.put(fruits[end],hm.getOrDefault(fruits[end],0)+1);
            if(hm.size()<=2)
            {
                ans=Math.max(ans,end-start+1);
            }
            else 
            {
                while(hm.size()>2)
                {
                    int val=fruits[start++];
                    if(hm.get(val)==1)
                        hm.remove(val);
                    else 
                        hm.put(val,hm.get(val)-1);
                }
            }
            ++end;
        }
        return ans;
    }
}