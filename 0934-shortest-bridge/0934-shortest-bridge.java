class Solution {
    public class Pair{
        int row;
        int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public void fnDfs(int grid[][],int row,int col,boolean [][]visited,Queue<Pair>q,int n)
    {
        visited[row][col]=true;
        q.add(new Pair(row,col));
        //System.out.println(row+" "+col);
        for(int i=-1;i<=1;i+=2)
        {
            int nr=i+row;
            if(nr>=0&&nr<n&&visited[nr][col]==false&&grid[nr][col]==1)
                fnDfs(grid,nr,col,visited,q,n);
            int nc=i+col;
            if(nc>=0&&nc<n&&visited[row][nc]==false&&grid[row][nc]==1)
                fnDfs(grid,row,nc,visited,q,n);
        }
            
    }
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int arr[][]=new int[n][n];
        Queue<Pair>q=new ArrayDeque<>();
        boolean visited[][]=new boolean[n][n];
        boolean check=false;
        for(int i=0;i<n;i++)
        {
           for( int j=0;j<n;j++)
           {
               if(grid[i][j]==1)
               {
                   fnDfs(grid,i,j,visited,q,n);
                   check=true;
                   break;
               }
               
           }
            if(check==true)
                break;
        }
      
        int steps=0;
        while(q.size()!=0)
        {
            int size=q.size();
         
            for(int i=0;i<size;i++)
            {
                Pair tmp=q.remove();
                System.out.println(tmp.row+" "+tmp.col);
                int row=tmp.row;
                int col=tmp.col;
                for(int j=-1;j<=1;j+=2)
                {
                    int nr=j+row;
            if(nr>=0&&nr<n&&visited[nr][col]==false)
            {
                if(grid[nr][col]==0)
                {
                     //System.out.println("HELLO");
                    visited[nr][col]=true;
                    q.add(new Pair(nr,col));
                }
                else 
                    return steps;
            }
                
            int nc=j+col;
            if(nc>=0&&nc<n&&visited[row][nc]==false)
            {
                
                 if(grid[row][nc]==0)
                {
                    
                    visited[row][nc]=true;
                    q.add(new Pair(row,nc));
                }
                else 
                    return steps;
            }   
            }
            }
             ++steps;
        }
        return -1;
        
    }
}