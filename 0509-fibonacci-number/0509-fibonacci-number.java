class Solution {
    public static int fnFib(int n,int arr[])
    {
        if(n<0)
            return 0;
        if(n<2)
            return n;
        if(arr[n]!=0)
            return arr[n];
        int fbn=fnFib(n-1,arr);
        int fbn2=fnFib(n-2,arr);
        int t=fbn+fbn2;
        arr[n]=t;
        return t;
            
    }
    public int fib(int n) {
        int arr[]=new int[n+1];
        int ans=fnFib(n,arr);
        return ans; 
    }
}