class Solution {
 public int[][] generateMatrix(int n) {
        int top=0,bottom=n-1,left=0,right=n-1,dir=0,c=1;
        int arr[][]=new int[n][n];
        while(top<=bottom&&left<=right)
        {
            if(dir==0)
            {
                for(int i=left;i<=right;i++)
                {
                    arr[top][i]=c++;
                    
                }
                ++dir;
                ++top;
            }
            else if(dir==1)
            {
                for(int i=top;i<=bottom;i++)
                {
                    arr[i][right]=c++;
                }
                ++dir;
                --right;
            }
            else if(dir==2)
            {
                for(int i=right;i>=left;i--)
                {
                    arr[bottom][i]=c++;
                }
                ++dir;
                --bottom;
            }
            else 
            {
                for(int i=bottom;i>=top;i--)
                {
                    arr[i][left]=c++;
                }
                ++left;
                ++dir;
            }
            dir%=4;
            
        }
        return arr;
    }
}