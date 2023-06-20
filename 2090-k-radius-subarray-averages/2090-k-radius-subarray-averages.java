class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        if(k==0)
            return nums;
        long pre[]=new long[n];
        long post[]=new long[n];
        pre[0]=nums[0];
        post[n-1]=nums[n-1];
        for(int i=1;i<n;i++)
        {
            pre[i]=pre[i-1]+nums[i];
        }
        for(int i=n-2;i>=0;i--)
        {
            post[i]=post[i+1]+nums[i];
        }
        // for(long i:pre)
        //     System.out.print(i+" ");
        // System.out.println();
        // for(long i:post)
        //     System.out.print(i+" ");
        // System.out.println();
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            long sum=0;
            long val=2*k+1;
            if(i-k>=0&&i+k<n)
            {
                if(i-k==0)
                    sum+=pre[i];
                else 
                    sum+=(pre[i]-pre[i-k-1]);
                //System.out.println(sum);
                if(i+k==n-1)
                    sum+=post[i+1];
                else 
                    sum+=(post[i+1]-post[i+k+1]);
               // System.out.println(sum);
                sum=sum/val;
                ans[i]=(int)sum;
            }
            else 
            {
                ans[i]=-1;
            }
        }
        return ans;
    }
}