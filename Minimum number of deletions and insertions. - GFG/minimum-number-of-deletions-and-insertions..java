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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    public int fnFind(int ind1,int ind2,String s1,String s2,int [][]dp)
    {
        if(ind1<0||ind2<0)
        return 0;
        if(dp[ind1][ind2]!=-1)
        return dp[ind1][ind2];
        int val1=0,val2=0;
        if(s1.charAt(ind1)==s2.charAt(ind2))
        val1=1+fnFind(ind1-1,ind2-1,s1,s2,dp);
        val2=Math.max(fnFind(ind1-1,ind2,s1,s2,dp),fnFind(ind1,ind2-1,s1,s2,dp));
        return dp[ind1][ind2]=Math.max(val1,val2);
    }
	public int minOperations(String s1, String s2) 
	{ 
	    // Your code goes here
	    int len1=s1.length(),len2=s2.length();
	    int dp[][]=new int [len1+1][len2+1];
	    for(int i=0;i<=len1;i++)
	    {
	        for(int j=0;j<=len2;j++)
	        dp[i][j]=-1;
	    }
	    int ans=fnFind(len1-1,len2-1,s1,s2,dp);
	   
	        return len1-ans+(len2-ans);
	    
	} 
}