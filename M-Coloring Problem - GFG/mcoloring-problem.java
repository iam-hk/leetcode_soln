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
    public boolean fnCheck(ArrayList<ArrayList<Integer>>adj,int []color,int node,int c)
    {
        for(int i:adj.get(node))
        {
            if(color[i]==c)
            return false;
            
        }
        return true;
    }
    public boolean fnColor(ArrayList<ArrayList<Integer>>adj,int n,int m,int color[],int node)
    {
        if(node==n)
        return true;
        
        for(int i=1;i<=m;i++)
        {
            if(fnCheck(adj,color,node,i))
            {
                color[node]=i;
                boolean check=fnColor(adj,n,m,color,node+1);
                if(check==true)
                return true;
                else 
                color[node]=0;
                
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer>a=new ArrayList<>();
            adj.add(new ArrayList<>(a));
            
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph.length;j++)
            {
                if(i==j)
                continue;
                if(graph[i][j]==true)
                adj.get(i).add(j);
                
            }
            
        }
        int color[]=new int[n];
        return fnColor(adj,n,m,color,0);
    }
}