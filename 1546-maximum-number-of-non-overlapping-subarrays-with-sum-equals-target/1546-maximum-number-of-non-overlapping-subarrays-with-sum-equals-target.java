class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int count=0,sum=0;
        HashSet<Integer>hs=new HashSet<>();
        hs.add(0);
        for(int i:nums)
        {
            sum+=i;
            if(hs.contains(sum-target))
            {
                hs=new HashSet<>();
                ++count;
                sum=0;
                hs.add(0);
            }
            hs.add(sum);
        }
        
           return count;
    }
}