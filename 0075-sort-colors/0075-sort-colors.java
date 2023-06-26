class Solution {
    public void sortColors(int[] nums) {
         int o=0,z=0,t=0;
        for(int i:nums)
        {
            if(i==1)
                o++;
            else if(i==2)
                t++;
            else
                z++;
            
        }
        for(int i=0;i<nums.length;i++)
        {
            if(z-->0)
                nums[i]=0;
            else if(o-->0)
                nums[i]=1;
            else 
                nums[i]=2;
        }
    }
}