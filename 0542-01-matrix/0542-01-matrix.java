class Solution {
    public class Pair{
        int r;
        int c;
        int dist;
        Pair(int r,int c,int dist)
        {
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }
    public void fnBfs(int mat[][],int visited[][],int row,int col)
    {
        Queue<Pair>q=new ArrayDeque<>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j,0));
                    
                }
            }
        }
        while(q.size()!=0)
        {
            Pair tmp=q.remove();
            int r=tmp.r;
            int c=tmp.c;
            int dist=tmp.dist;
            for(int i=-1;i<=1;i+=2)
            {
                if(r+i>=0&&r+i<row&&mat[r+i][c]==1&&visited[r+i][c]==0)
                {
                     q.add(new Pair(r+i,c,dist+1));
                     visited[r+i][c]=dist+1;   
                }
                if(c+i>=0&&c+i<col&&mat[r][c+i]==1&&visited[r][c+i]==0)
                {
                     q.add(new Pair(r,c+i,dist+1));
                     visited[r][c+i]=dist+1;   
                }
            }
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int visited[][]=new int[row][col];
        fnBfs(mat,visited,row,col);
        return visited;
    }
}