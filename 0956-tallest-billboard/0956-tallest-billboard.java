class Solution {
    int dp[][];
    public int fnSolve(int i,int diff,int []rods)
    {
     
        if(i==rods.length)
        {
            if(diff==0)
                return 0;
            return (int)-1e9+7;
        }
        if(dp[i][diff+5000]!=-1)
            return dp[i][diff+5000];
        int a1=rods[i]+fnSolve(i+1,diff+rods[i],rods);
        int a2=fnSolve(i+1,diff-rods[i],rods);
        int a3=fnSolve(i+1,diff,rods);
        return dp[i][diff+5000]=Math.max(a1,Math.max(a2,a3));
    }
    public int tallestBillboard(int[] rods) {
        dp=new int[21][10000];
        for(int i=0;i<21;i++){
            for(int j=0;j<10000;j++)
                dp[i][j]=-1;
        }
        return fnSolve(0,0,rods);
    }
}