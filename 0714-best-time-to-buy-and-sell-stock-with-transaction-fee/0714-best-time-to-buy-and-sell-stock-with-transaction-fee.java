class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int bs=-prices[0],ss=0;

        for(int i=1;i<n;i++)
        {
            int b_val=Math.max(bs,ss-prices[i]);
            int s_val=Math.max(prices[i]-fee+bs,ss);
            bs=b_val;
            ss=s_val;
        }
        return ss;
    }
}