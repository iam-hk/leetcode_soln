class Solution {
    static int mod=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer dp[][]=new Integer[n+1][target+1];
        return fun(n,k,target,dp);
    }
    static int fun(int n,int k,int target,Integer dp[][])
    {
        if(target<0)
            return 0;
        if(n==0)
        {
            if(target==0)
                return 1;
            return 0;
        }
        if(dp[n][target]!=null)
            return dp[n][target];
        int count=0;
        for(int i=1; i<=k; i++)
            count=(count+fun(n-1,k,target-i,dp))%mod;
        dp[n][target]=count;
        return dp[n][target];
    }
}