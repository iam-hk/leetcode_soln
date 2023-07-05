class Solution {
    public int longestSubarray(int[] nums) {
        int start=0,end=0,ans=0,n=nums.length,count=0;
        boolean check=false;
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
            ans=Math.max(end-start+1-count,ans);
            ++end;
        }
        if(check==false)
            return n-1;
        return ans;
    }
}