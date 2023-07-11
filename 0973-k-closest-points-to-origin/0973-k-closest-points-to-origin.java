class Solution {
    public class Pair implements Comparable<Pair>{
        double d;
        int x;
        int y;
        Pair(double d,int x,int y)
        {
            this.d=d;
            this.x=x;
            this.y=y;
            
        }
        public int compareTo(Pair o)
        {
            if(this.d-o.d>0)
                return 1;
            else 
                return -1;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        for(int i=0;i<points.length;i++)
        {
            int x=points[i][0];
            int y=points[i][1];
            double dist=Math.sqrt(x*x+y*y);
            pq.add(new Pair(dist,x,y));
        }
        int ans[][]=new int[k][2];
        int i=0;
        while(i<k)
        {
            Pair tmp=pq.poll();
            ans[i][0]=tmp.x;
            ans[i][1]=tmp.y;
            ++i;
            
        }
        return ans;
    }
}