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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] shortestPath(int[][] edges,int V,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        adj.add(new ArrayList<Integer>());
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<m;i++)
        {
            int s1=edges[i][0];
            int s2=edges[i][1];
            adj.get(s1).add(s2);
            adj.get(s2).add(s1);
        }
        boolean visited[]=new boolean[V];
        q.add(src);
        visited[src]=true;
        int ans[]=new int[V];
        // for(int i=0;i<V;i++)
        // ans[i]=Integer.MAX_VALUE;
        // ans[src]=0;
        while(q.size()!=0)
        {
            int tmp=q.remove();
            int dist=ans[tmp];
            for(int i:adj.get(tmp))
            {
                if(visited[i]==false)
                {
                int wt1=dist+1;
                ans[i]=wt1;
                q.add(i);
                visited[i]=true;
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            ans[i]=-1;
        }
        return ans;
    }
}