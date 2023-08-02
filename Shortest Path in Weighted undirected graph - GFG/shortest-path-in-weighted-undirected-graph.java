//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static class Pair implements Comparable<Pair>{
        int node;
        int wt;
        Pair(int node,int wt)
        {
            this.node=node;
            this.wt=wt;
            
        }
        public int compareTo(Pair o)
        {
            return this.wt-o.wt;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int s1=edges[i][0];
            int s2=edges[i][1];
            int wt=edges[i][2];
            adj.get(s1).add(new Pair(s2,wt));
            adj.get(s2).add(new Pair(s1,wt));
        }
        int dist[]=new int[n+1];
        int par[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
            par[i]=i;
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        dist[1]=0;
        pq.add(new Pair(1,0));
        while(pq.size()!=0)
        {
            Pair tmp=pq.remove();
            int node=tmp.node;
            int wt=tmp.wt;
            for(Pair i:adj.get(node))
            {
                int nd=i.node;
                int d=i.wt;
                if(dist[nd]>wt+d)
                {
                    dist[nd]=wt+d;
                    par[nd]=node;
                    pq.add(new Pair(nd,wt+d));
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        int st=n;
        ans.add(st);
        while(st!=1)
        {
            if(st!=1&&par[st]==st)
            {
                ans=new ArrayList<>();
                ans.add(-1);
                return ans;
            }
            ans.add(par[st]);
            st=par[st];
        }
        Collections.reverse(ans);
        return ans;
        
    }
}