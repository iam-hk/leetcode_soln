//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String s1) {
        //your code here
        String s2="";
        for(int i=0;i<s1.length();i++)
        s2=s1.charAt(i)+s2;
         int n1=s1.length(),n2=s2.length();
        int dp[][]=new int[n1+1][n2+1];
         for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                
        if(s1.charAt(i-1)==s2.charAt(j-1))
        dp[i][j]=1+dp[i-1][j-1];
        else
        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
       
            }
        }
        return s1.length()-dp[n1][n2];
    }
}