//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long fnFind(int []coins,int n,int sum,int index,long dp[][])
    {
        if(index==n-1)
        {
            if(sum==0)
            return 1L;
            if(sum%coins[index]==0)
            return 1L;
            return 0L;
        }
        if(dp[index][sum]!=-1)
        return dp[index][sum];
        
        long take=0L;
        if(sum-coins[index]>=0)
        take=fnFind(coins,n,sum-coins[index],index,dp);
        long not=fnFind(coins,n,sum,index+1,dp);
        return dp[index][sum]=take+not;
    }
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][]=new long[N][sum+1];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<=sum;j++)
            dp[i][j]=-1;
        }
        return fnFind(coins,N,sum,0,dp);
    }
}