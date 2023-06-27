class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=i+1&&nums[nums[i]-1]!=nums[i])
            {
                int index=nums[i]-1;
                int tmp=nums[i];
                nums[i]=nums[index];
                nums[index]=tmp;
                --i;
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=i+1)
                ans.add(i+1);
        }
        return ans;
    }
}