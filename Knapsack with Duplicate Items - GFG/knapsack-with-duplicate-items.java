//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int fnFind(int n,int w,int val[],int wt[],int index,int dp[][])
    {
        if(w==0)
        return 0;
        if(w<0)
        return Integer.MIN_VALUE;
        if(index==n)
        {
           
            return Integer.MIN_VALUE;
        }
        if(dp[index][w]!=-1)
        return dp[index][w];
        int take=0;
        if(w-wt[index]>=0)
        take=val[index]+fnFind(n,w-wt[index],val,wt,index,dp);
        int not=fnFind(n,w,val,wt,index+1,dp);
        return dp[index][w]=Math.max(take,not);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][]=new int [N][W+1];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<=W;j++)
            dp[i][j]=-1;
        }
        return fnFind(N,W,val,wt,0,dp);
    }
}