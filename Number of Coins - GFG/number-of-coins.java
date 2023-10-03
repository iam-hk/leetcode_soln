//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

    public  int fnFind(int arr[],int index,int x,int dp[][],int n)
    {
            if(x<0)
            return (int)1e9;
            if(x==0)
            return 0;
            if(index==n)
            return (int)1e9;
            if(dp[index][x]!=-1)
            return dp[index][x];
            int take=1+fnFind(arr,index,x-arr[index],dp,n);
            int not=fnFind(arr,index+1,x,dp,n);
            return dp[index][x]=Math.min(take,not);


    }
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    
        int dp[][]=new int[M][V+1];
        for(int i=0;i<M;i++)
        {
            for(int j=0;j<=V;j++)
            dp[i][j]=-1;
        }

       int ans=fnFind(coins,0,V,dp,M);
       if(ans>(int)1e7)
       ans=-1;
       return ans;
	} 
}