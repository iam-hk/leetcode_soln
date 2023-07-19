//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public class Pair{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time)
        {
            this.row=row;
            this.col=col;
            this.time=time;
        }
        
    } 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        Queue<Pair>q=new ArrayDeque<>();
        int rows=grid.length;
        int cols=grid[0].length;
         boolean visited[][]=new boolean[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
       
        int ans=0;
        while(q.size()!=0)
        {
            Pair tmp=q.remove();
            int r=tmp.row;
            int c=tmp.col;
            int time=tmp.time;
            for(int i=-1;i<=1;i+=2)
            {
                int nr=r+i;
                if(nr>=0&&nr<rows&&visited[nr][c]==false&&grid[nr][c]==1)
                {
                    visited[nr][c]=true;
                    grid[nr][c]=2;
                    q.add(new Pair(nr,c,time+1));
                    ans=time+1;
                }
                int nc=c+i;
                if(nc>=0&&nc<cols&&visited[r][nc]==false&&grid[r][nc]==1)
                {
                    visited[r][nc]=true;
                    grid[r][nc]=2;
                    q.add(new Pair(r,nc,time+1));
                    ans=time+1;
                }
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            if(grid[i][j]==1)
            return -1;
        }
        return ans;
    }
}