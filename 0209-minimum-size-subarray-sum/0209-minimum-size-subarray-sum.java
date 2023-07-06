class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0,end=0,n=nums.length,sum=0,ans=nums.length+1;
        while(end<n)
        {
            sum+=nums[end];
            while(sum>=target)
            {
                if(sum>=target)
                    ans=Math.min(ans,end-start+1);
                sum-=nums[start++];
                
            }
            
            ++end;
        }
        if(ans==nums.length+1)
            return 0;
        
        return ans;
    }
}