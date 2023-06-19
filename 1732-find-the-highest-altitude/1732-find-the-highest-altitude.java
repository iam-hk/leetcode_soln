class Solution {
    public int largestAltitude(int[] gain) {
        int max=0,pre=0;
        for(int i:gain)
        {
            pre+=i;
            max=Math.max(max,pre);
        }
        return max;
    }
}