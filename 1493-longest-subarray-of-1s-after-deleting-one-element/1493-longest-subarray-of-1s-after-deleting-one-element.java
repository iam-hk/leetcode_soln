class Solution {
    public int longestSubarray(int[] nums) {
        int start=0,end=0,n=nums.length;
        int count=0;
        boolean check=false;
        int ans=0;
        while(end<n)
        {
            int val=nums[end];
            if(val==0)
                ++count;
            if(count>1)
            {
                check=true;
                if(nums[start++]==0)
                    --count;
            }
            else 
                ans=Math.max(ans,end-start+1-count);
            ++end;
        }
        if(check==false)
            return n-1;
        return ans;
            
    }
}