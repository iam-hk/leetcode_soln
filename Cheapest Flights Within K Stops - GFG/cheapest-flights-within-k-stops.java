//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public class Pair implements Comparable<Pair>
    {
        int node;
        int cost;
        int stops;
        Pair(int node,int cost,int stops)
        {
            this.node=node;
            this.cost=cost;
            this.stops=stops;
            
        }
        public int compareTo(Pair o)
        {
            return this.stops-o.stops;
            
        }
    }
    public int CheapestFLight(int n,int flights[][],int src,int dstn,int k) {
        // Code here
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Pair>());
            
        }
        int dst[]=new int[n];
        for(int i=0;i<flights.length;i++)
        {
            int s=flights[i][0];
            int d=flights[i][1];
            int cost=flights[i][2];
            adj.get(s).add(new Pair(d,cost,0));
        }
        for(int i=0;i<n;i++)
        {
            dst[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(src,0,0));
        dst[src]=0;
        while(pq.size()!=0)
        {
            Pair tmp=pq.remove();
            int node=tmp.node;
            int cost=tmp.cost;
            int stops=tmp.stops;
            for(Pair i:adj.get(node))
            {
                int nd=i.node;
                int c=i.cost;
                if(dst[nd]>cost+c)
                {
                    if(stops<=k)
                    {
                        dst[nd]=cost+c;
                        pq.add (new Pair(nd,cost+c,stops+1));
                    }
                }
            }
        }
        if(dst[dstn]==Integer.MAX_VALUE)
        return -1;
        return dst[dstn];
        
    }
}