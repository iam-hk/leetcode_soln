class Solution {
    public class Pair{
        int r;
        int c;
        int time;
        Pair(int r,int c,int time)
        {
            this.r=r;
            this.c=c;
            this.time=time;


        }
    }
    int t=0;

    public void fnBFS(int grid[][],boolean visited[][],int row,int col)
    {
        Queue<Pair>q=new ArrayDeque<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        while(q.size()!=0)
        {
            Pair tmp=q.remove();
            int r=tmp.r;
            int c=tmp.c;
            int time=tmp.time;
            for(int i=-1;i<=1;i+=2)
            {
                int nr=r+i;
                if(nr>=0&&nr<row&&visited[nr][c]==false&&grid[nr][c]==1)
                {
                    grid[nr][c]=2;
                    visited[nr][c]=true;
                    q.add(new Pair(nr,c,time+1));
                    t=Math.max(t,time+1);

                }
                int nc=c+i;
                if(nc>=0&&nc<col&&visited[r][nc]==false&&grid[r][nc]==1)
                {
                    grid[r][nc]=2;
                    visited[r][nc]=true;
                    q.add(new Pair(r,nc,time+1));
                    t=Math.max(t,time+1);
                }
            }

        }
    }
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean visited[][]=new boolean[row][col];
        fnBFS(grid,visited,row,col);
        int check=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
               System.out.print(grid[i][j]+" ");
               if(grid[i][j]==1)
               check=1;
            }
            System.out.println();
        }
        if(check==1)
        return -1;
        return t;

    }
}