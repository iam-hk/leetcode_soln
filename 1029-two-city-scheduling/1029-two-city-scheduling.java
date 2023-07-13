class Solution {
    class Pair implements Comparable<Pair>{
        int op;
        int np;
        int diff;
        Pair(int op,int np,int diff)
        {
            this.op=op;
            this.np=np;
            this.diff=diff;
        }
        public int compareTo(Pair o)
        {
            return o.diff-this.diff;
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        int total=0;
        int len=costs.length;
        for(int i=0;i<costs.length;i++)
        {
            int v1=costs[i][0];
            total+=v1;
            int v2=costs[i][1];
            int diff=v1-v2;
        pq.add(new Pair(v1,v2,diff));
        }
        for(int i=0;i<len/2;i++)
        {
            Pair tmp=pq.poll();
            total-=tmp.op;
            total+=tmp.np;
        }
        return total;
    }
}