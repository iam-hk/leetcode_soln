class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int ans=0,check=0;
        if(target<nums[0])
            return 0;
        else if(target>nums[end])
            return end+1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
            {
                
                start=mid+1;
                
            }
            else
            {
                ans=mid; 
                end=mid-1;
            }
        }
        
        return ans;
            
    }
}