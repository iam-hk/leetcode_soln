class Solution {
    public int maxDistToClosest(int[] seats) {
         int last=-1,ans=0;
        for(int i=0;i<seats.length;i++)
        {
            if(seats[i]==1)
            {
                if(last==-1)
                {
                    last=i;
                    ans=Math.max(ans,(last));
                }
                else 
                {
                    ans=Math.max(ans,(i-last)/2);
                    last=i;
                }
            }
        }
       int n=seats.length;
        if(seats[n-1]==0)
        ans=Math.max(ans,(n-1-last));
       return ans;
    }
}