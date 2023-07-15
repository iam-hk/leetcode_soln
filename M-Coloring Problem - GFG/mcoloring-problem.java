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
    public boolean fnColor(boolean graph[][],int m,int n,int node,int[]color)
    {
        if(node==n)
        return true;
        for(int i=1;i<=m;i++)
        {
            
            boolean k=fnIsValid(graph,n,node,color,i);
            if(k==true)
            {
            color[node]=i;
            boolean t=fnColor(graph,m,n,node+1,color);
            if(t==true)
            return true;
            else 
            color[node]=0;
            }
            
        }
        return false;
        
    }
    public boolean fnIsValid(boolean graph[][],int n,int node,int color[],int c)
    {
        if(node==4)
        {
        //     System.out.println("color is"+c);
        // for(int i:color)
        // System.out.print(i+",");
        // System.out.println();
        }
        for(int i=0;i<graph.length;i++)
        {
            if(graph[node][i]==true)
            {
                if(c==color[i])
                return false;
            }
            
            
        }
        // if(node==3)
        // System.out.println("node3");
        return true;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[]=new int[n];
        
        // for(int i=0;i<graph.length;i++)
        // {
        //     for(int j=0;j<graph[i].length;j++)
        //     System.out.print(graph[i][j]+" ");
        //     System.out.println();
        // }
        boolean ans= fnColor(graph,m,n,0,color);
        // for(int i:color)
        // System.out.print(i+" ");
        return ans;
        
    }
}