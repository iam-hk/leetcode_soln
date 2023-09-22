//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        
        // Code here
        int mod=(int)1e9+7;
        long b=1,s=1;
        for(int i=2;i<=N;i++)
        {
            long nb=s%mod;
            long ns=(b+s)%mod;
            b=nb;
            s=ns;
            
        }
        long ans=b+s;
        ans*=ans;
        ans%=mod;
        return (int)ans;
    }
}