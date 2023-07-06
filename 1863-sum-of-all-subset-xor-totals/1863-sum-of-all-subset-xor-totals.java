class Solution {
    int sum=0;
    public void fnSubset(int nums[],int xor,int index)
    {
        if(index==nums.length)
        {
            sum+=xor;
            return ;
            
        }
        xor^=nums[index];
        fnSubset(nums,xor,index+1);
        xor^=nums[index];
        fnSubset(nums,xor,index+1);
    }
    public int subsetXORSum(int[] nums) {
            fnSubset(nums,0,0);
        return sum;
    }
}