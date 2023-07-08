class Solution {
    public long putMarbles(int[] weights, int k) {
        ArrayList<Integer>cost=new ArrayList<>();
        if(k==1||k==weights.length)
            return 0L;
        for(int i=0;i<weights.length-1;i++)
        {
            cost.add(weights[i]+weights[i+1]);
        }
        Collections.sort(cost);
        long ans=0;
        int len=cost.size();
        for(int i=0;i<k-1;i++)
        {
            ans+=(cost.get(len-i-1)-cost.get(i));
        }
        return ans;
    }
}