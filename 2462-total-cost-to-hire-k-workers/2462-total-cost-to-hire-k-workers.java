class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer>pq_front=new PriorityQueue<>();
        PriorityQueue<Integer>pq_back=new PriorityQueue<>();
        int n=costs.length;
        int s=0,e=n-1;
        for(int i=0;i<candidates;i++)
        {
            pq_front.add(costs[i]);
            if(i>=n)
                break;
            ++s;
        }
        if(s<n-1)
        {
            for(int i=n-1;i>=n-candidates;i--)
            {
                pq_back.add(costs[i]);
                --e;
                if(e<s)
                    break;
            }
        }
        long ans=0;
        //System.out.println(s+ " "+e);
        for(int i=0;i<k;i++)
        {
            if(pq_front.size()==0)
            {
                ans+=pq_back.poll();
                if(e>=s)
                    pq_back.add(costs[e--]);
            }
            else if(pq_back.size()==0)
            {
                ans+=pq_front.poll();
                if(s<=e)
                    pq_front.add(costs[s++]);
            }
            else 
            {
                if(pq_front.peek()>pq_back.peek())
                {
                    ans+=pq_back.poll();
                     if(e>=s)
                    pq_back.add(costs[e--]);
                }
                else if(pq_front.peek()<=pq_back.peek())
                {
                    ans+=pq_front.poll();
                    if(s<=e)
                    pq_front.add(costs[s++]);
                }
                //System.out.println(ans);
                }
            }
            
    return ans;
    }
}
