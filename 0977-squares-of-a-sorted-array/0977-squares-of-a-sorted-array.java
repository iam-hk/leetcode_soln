class Solution {
    public int[] sortedSquares(int[] nums) {
         int n=nums.length;
        int ans[]=new int[n];
        int s=0,e=n-1;
        int index=n-1;
        while(s<=e)
        {
            int v1=nums[s]*nums[s];
            int v2=nums[e]*nums[e];
            if(v1>v2)
            {
                ans[index]=v1;
                ++s;
            }
            else
            {
                ans[index]=v2;
                --e;
            }
            --index;
        }
        return ans;
    }
}