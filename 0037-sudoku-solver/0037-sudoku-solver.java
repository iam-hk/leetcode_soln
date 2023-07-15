class Solution {
    public boolean fnFill(char [][]board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char c='1';c<='9';c++)
                    {
                        if(fnIsValid(board,i,j,c))
                        {
                            board[i][j]=c;
                            boolean k=fnFill(board);
                            if(k==true)
                                return true;
                            else 
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean fnIsValid(char board[][],int i,int j,char ch)
    {
        for(int l=0;l<9;l++)
        {
            if(board[i][l]==ch)
                return false;
            if(board[l][j]==ch)
                return false;
            if(board[3*(i/3)+l/3][3*(j/3)+l%3]==ch)
                return false;
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
     fnFill(board);   
    }
}