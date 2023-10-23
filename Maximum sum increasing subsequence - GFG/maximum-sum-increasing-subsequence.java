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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int sum[]=new int[n];
	    
	    for(int i=0;i<n;i++)
	    {
	        sum[i]=arr[i];
	    }
	    for(int i=1;i<n;i++)
	    {
	        int val=arr[i];
	        for(int j=i-1;j>=0;j--)
	        {
	            if(val>arr[j])
	            {
	                if(sum[j]+val>sum[i])
	                {
	                   sum[i]=sum[j]+val;    
	                }
	            }
	        }
	       
	    }
	     int ans=0;
	     for(int i:sum)
	        ans=Math.max(i,ans);
	    return ans;
	}  
}