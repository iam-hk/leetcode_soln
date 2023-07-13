class Solution {
    public boolean isPossible(int row,int col,int n,List<String>a )
    {
        int dp_row=row;
        int dp_col=col;
        while(dp_row>=0&&dp_col>=0)
        {
            if(a.get(dp_row).charAt(dp_col)=='Q')
                return false;
            --dp_row;
            --dp_col;
        }
        dp_row=row;
        dp_col=col;
        while(dp_col>=0)
        {
            if(a.get(dp_row).charAt(dp_col)=='Q')
                return false;
            --dp_col;
        }
         dp_row=row;
        dp_col=col;
        while(dp_row<n&&dp_col>=0)
        {
            if(a.get(dp_row).charAt(dp_col)=='Q')
                return false;
            --dp_col;
            ++dp_row;
        }
        return true;
            
    }
    public void fnGenerate(int col,int n,List<String>a,List<List<String>>ans)
    {
        
        if(col==n)
        {
            for(int i=0;i<a.size();i++)
            {
                String s=a.get(i);
                for(int j=0;j<s.length();j++)
                    System.out.print(s.charAt(j)+" ");
                System.out.println();
                 
                
            }
             System.out.println();
             System.out.println();
            ans.add(new ArrayList<>(a));
            return ;
        }
        for(int i=0;i<n;i++)
        {
            if(isPossible(i,col,n,a))
            {
                String s=a.get(i);
                char ch[]=s.toCharArray();
                ch[col]='Q';
                s=new String(ch);
                a.set(i,s);
                fnGenerate(col+1,n,a,ans);
                  s=a.get(i);
                char ch1[]=s.toCharArray();
                ch1[col]='.';
                s=new String(ch1);
                a.set(i,s);
                
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        List<String>a=new ArrayList<>();
        String s="";
        for(int i=0;i<n;i++)
            s+='.';
        for(int i=0;i<n;i++)
            a.add(s);
        fnGenerate(0,n,a,ans);
        return ans;
    }
}


