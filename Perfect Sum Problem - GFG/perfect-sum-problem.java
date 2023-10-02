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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod=(int)1e9+7;
    public int fnFind(int index,int target,int arr[],int n,int dp[][])
    {
        if(target<0)
        return 0;
        if(index==n)
        {
            if(target==0)
            return 1;
            return 0;
        }
       
        if(dp[index][target]!=-1)
        return dp[index][target];
        int ways1=fnFind(index+1,target-arr[index],arr,n,dp)%mod;
        int ways2=fnFind(index+1,target,arr,n,dp)%mod;
        return dp[index][target]=(ways1+ways2)%mod;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n+1][sum+1];
	    for(int i=0;i<=n;i++)
	    {
	        for(int j=0;j<=sum;j++)
	        dp[i][j]=-1;
	    }
	   // for(int i=0;i<=n;i++)
	   // dp[i][0]=1;
	   // for(int i=1;i<=n;i++)
	   // {
	   //     int element=arr[i-1];
	   //     for(int j=1;j<=sum;j++)
	   //     {
	   //         if(element>j)
	   //         continue;
	   //         if(dp[i-1][j-element]==1)
	   //         dp[i][j]=1;
	            
	   //     }
	   // }
	   // for(int i=0;i<=n;i++)
	   // {
	   //     for(int j=0;j<=sum;j++)
	   //     System.out.print(dp[i][j]+" ");
	   //     System.out.println();
	   // }
	   // long ans=0;
	   // for(int i=0;i<=n;i++)
	   // {
	   //     ans+=dp[i][sum];
	   //     ans%=(int)1e9+7;
	   // }
	   // return (int)ans;
	   return fnFind(0,sum,arr,n,dp);
	} 
}