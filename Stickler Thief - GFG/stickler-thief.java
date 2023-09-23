//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int fnAns(int arr[],int n,int dp[])
    {
        if(n<0)
        return 0;
        if(n==0)
        return arr[n];
        if(dp[n]!=0)
        return dp[n];
        int take=arr[n]+fnAns(arr,n-2,dp);
        int nottake=fnAns(arr,n-1,dp);
        int ans=Math.max(take,nottake);
        return dp[n]=ans;
    }
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int dp[]=new int[n];
        return fnAns(arr,n-1,dp);
        
    }
}