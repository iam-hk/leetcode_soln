class Solution {
    public int findPeakElement(int[] nums) {
         if(nums.length==1)
            return 0;
        else if(nums.length==2)
        {
            if(nums[0]>nums[1])
                return 0;
            return 1;
        }
        int start=0,end=nums.length-1,n=nums.length;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(mid==0)
            {
                if(nums[mid]>nums[mid+1])
                    return mid;
                else 
                    start=mid+1;
            }
            else if(mid==n-1)
            {
                if(nums[mid]>nums[mid-1])
                    return mid;
                end=mid-1;
            }
            else
            {
                int val1=nums[mid-1];
                int val2=nums[mid];
                int val3=nums[mid+1];
                if(val2>val1&&val2>val3)
                    return mid;
                else if(nums[mid]>val3)
                    end=mid-1;
                else 
                    start=mid+1;
            }
                
        }
        return -1;
    }
}