//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean isPossible(int node,int i,int color[],List<List<Integer>>adj)
    {
        for(int j:adj.get(node))
        {
            if(color[j]==i)
            return false;
        }
        return true;
    }
    public boolean fnCheck(int m,int n,int[]color,List<List<Integer>> adj,int node)
    {
        if(node==n)
        return true;
        for(int i=1;i<=m;i++)
        {
            if(isPossible(node,i,color,adj))
            {
                color[node]=i;
                boolean k=fnCheck(m,n,color,adj,node+1);
                if(k==true)
                return true;
                color[node]=0;
            }
            
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++)
        {
           for(int j=0;j<graph.length;j++)
           {
               if(graph[i][j]==true)
               adj.get(i).add(j);
           }
        }
        int color[]=new int[n];
        return fnCheck(m,n,color,adj,0);
    }
}