class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int max=1;
        for(int i:arr)
        {
            if(hm.containsKey(i-difference))
                hm.put(i,hm.get(i-difference)+1);
            else 
                hm.put(i,1);
            max=Math.max(hm.get(i),max);
        }
        return max;
    }
}