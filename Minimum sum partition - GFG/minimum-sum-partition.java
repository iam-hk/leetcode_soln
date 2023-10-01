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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
	    for(int i:arr)
	    sum+=i;
	    boolean dp[][]=new boolean[n+1][sum+1];
	    for(int i=0;i<=n;i++)
	    dp[0][i]=true;
	    for(int i=1;i<=sum;i++)
	    dp[0][i]=false;
	    for(int i=1;i<=n;i++)
	    {
	        int value=arr[i-1];
	        for(int j=1;j<=sum;j++)
	        {
	               if(value>j)
	               dp[i][j]=dp[i-1][j];
	               else 
	               {
	                   int nv=j-value;
	                   if(dp[i-1][nv]==true||dp[i-1][j]==true)
	                   dp[i][j]=true;
	                   else 
	                   dp[i][j]=false;
	               }
	        }
	        
	    }
	   // for(int i=0;i<=n;i++)
	   // {
	   //     for(int j=0;j<=sum;j++)
	   //     System.out.print(dp[i][j]+" ");
	   //     System.out.println();
	   // }
	    int ans=sum;
	    for(int i=1;i<=sum;i++)
	    {
	        if(dp[n][i]==true)
	        {
	            int val=sum-i;
	             ans=Math.min(ans,Math.abs(val-i));
	        }
	       
	    }
	    return ans;
	} 
}
