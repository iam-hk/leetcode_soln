//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends

class Solution{
    public int fnFind(int price[],int n,int index,int dp[][],int len)
    {
        if(n==0)
        return 0;
        if(n<0)
        return Integer.MIN_VALUE;
        if(index==len)
        {
            
            return Integer.MIN_VALUE;
        }
        if(dp[index][n]!=-1)
        return dp[index][n];
        int v1=0;
        if(n-(index+1)>=0)
        v1=price[index]+fnFind(price,n-(index+1),index,dp,len);
        int v2=fnFind(price,n,index+1,dp,len);
        return dp[index][n]=Math.max(v1,v2);
    }
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=n;j++)
            dp[i][j]=-1;
        }
        return fnFind(price,n,0,dp,n);
    }
}