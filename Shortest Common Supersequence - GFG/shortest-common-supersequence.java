//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int fnFind(int l1,int l2,String s1,String s2,int dp[][])
    {
        if(l1<0||l2<0)
        return 0;
        if(dp[l1][l2]!=-1)
        return dp[l1][l2];
        int val1=0,val2=0;
        if(s1.charAt(l1)==s2.charAt(l2))
        val1=1+fnFind(l1-1,l2-1,s1,s2,dp);
        val2=Math.max(fnFind(l1-1,l2,s1,s2,dp),fnFind(l1,l2-1,s1,s2,dp));
        return dp[l1][l2]=Math.max(val1,val2);
    }
    public static int shortestCommonSupersequence(String s1,String s2,int m,int n)
    {
        //Your code here
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        }
        int ans=fnFind(m-1,n-1,s1,s2,dp);
       // System.out.println(ans);
        return m+n-ans;
    }
}