class Solution {
    public class Pair implements Comparable<Pair>{
        int v1;
        int v2;
        int sum;
        Pair(int v1,int v2)
        {
            this.v1=v1;
            this.v2=v2;
            this.sum=v1+v2;
            
        }
        public int compareTo(Pair o)
        {
            return o.sum-this.sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                int sum=nums1[i]+nums2[j];
                if(pq.size()<k)
                {
                    pq.add(new Pair(nums1[i],nums2[j]));
                }
                else
                {
                    if(sum<pq.peek().sum)
                    {
                        pq.poll();
                        pq.add(new Pair(nums1[i],nums2[j]));
                    }
                    else
                        break;
                }
                    
            }
        }
        while(pq.size()!=0)
        {
            List<Integer>l=new ArrayList<>();
            Pair tmp=pq.poll();
            l.add(tmp.v1);
            l.add(tmp.v2);
            ans.add(l);
        }
        return ans;
    }
}