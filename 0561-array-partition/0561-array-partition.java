class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE,ans=0;
        for(int i=0;i<nums.length-1;i++)
        {
            min=Math.min(nums[i],nums[i+1]);
            ans+=min;
            ++i;
        }
        return ans;
    }
}