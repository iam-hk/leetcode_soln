class Solution {
    public class Pair implements Comparable<Pair>{
        int st=0;
        int et=0;
        Pair(int st,int et)
        {
            this.st=st;
            this.et=et;
                
        }
        public int compareTo(Pair o)
        {
            if(this.st==o.st)
                return this.et-o.et;
            return this.et-o.et;
        }
    }
    public int maxEvents(int[][] events) {
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<events.length;i++)
        {
           pq.add(new Pair(events[i][0],events[i][1])); 
        }
        int p_et=-1;
        int count=0,time=1;
        int i=0;
        while(pq.size()!=0)
        {
            Pair tmp=pq.poll();
              events[i][0]=tmp.st;
              events[i][1]=tmp.et;
            ++i;
                
        }
        TreeSet<Integer>ts=new TreeSet<>();
        for( i=1;i<=100000;i++)
            ts.add(i);
        int ans=0;
        for( i=0;i<events.length;i++)
        {
            int st=events[i][0];
            int et=events[i][1];
            Integer avail=ts.ceiling(st);
            if(avail!=null&&avail<=et)
            {
                ++ans;
                ts.remove(avail);
            }
                
        }
        return ans;
    }
}