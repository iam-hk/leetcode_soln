class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int ans[]=new int[arr.length];
        int post[]=new int[arr.length];
        post[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
            post[i]=Math.max(arr[i],post[i+1]);
         ans[n-1]=-1;
        for(int i=n-2;i>=0;i--)
        {
            ans[i]=post[i+1];
        }
        return ans;
    }
}