//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    public static int fnRec(int index,int W,int []wt,int []val,int n,int dp[][])
    {
     if(index==n-1)
     {
         if(W>=wt[index])
         return val[index];
         return 0;
     }
       if(dp[index][W]!=-1)
       return dp[index][W];
     if(W<0)
     return 0;
     int val1=0;
     if(W>=wt[index])
     val1=val[index]+fnRec(index+1,W-wt[index],wt,val,n,dp);
     int val2=fnRec(index+1,W,wt,val,n,dp);
     return dp[index][W]=Math.max(val1,val2);
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][]=new int [n+1][W+1];
         for(int i=0;i<=n;i++)
         {
             for(int j=0;j<=W;j++)
             dp[i][j]=-1;
         }
        //  for(int i=1;i<=n;i++)
        //  {
        //      int curwt=wt[i-1];
        //      int curval=val[i-1];
        //      for(int j=1;j<=W;j++)
        //      {
        //          if(j>=curwt)
        //          {
        //              dp[i][j]=Math.max(dp[i-1][j],curval+dp[i-1][j-curwt]);
        //          }
        //          else 
        //          dp[i][j]=dp[i-1][j];
        //      }
        //  }
        //  int ans=0;
        //  for(int i=1;i<=n;i++)
        //  ans=Math.max(ans,dp[i][W]);
        return fnRec(0,W,wt,val,n,dp);
        //  return ans;
    } 
}


