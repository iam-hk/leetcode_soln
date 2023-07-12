class Solution 
{
    public int[][] buildMatrix(int k, int[][] row, int[][] col)     
    {
        int ans[][]=new int[k][k];
        ++k;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        
        
        for(int i=0;i<k;i++)
            adj.add(new ArrayList<Integer>());
        int indeg[]=new int[k];
        for(int i=0;i<row.length;i++)
        {
            int s=row[i][0];
            int d=row[i][1];
            adj.get(s).add(d);
            indeg[d]++;
        }
        Queue<Integer>q=new ArrayDeque<>();
        int r[]=new int[k];
        int c[]=new int[k];
        
        for(int i=1;i<k;i++)
            if(indeg[i]==0)
                q.add(i);
        int count=0;
        while(q.size()!=0)
        {
            int tmp=q.remove();
            r[tmp]=count++;
            for(int i:adj.get(tmp))
            {
                indeg[i]--;
                if(indeg[i]==0)
                    q.add(i);
            }
        }
         System.out.println(count);
        if(count<k-1)
            return new int[0][0];
         //System.out.println(count);
        Arrays.fill(indeg,0);
        adj=new ArrayList<>();
        for(int i=0;i<k;i++)
            adj.add(new ArrayList<Integer>());
       for(int i=0;i<col.length;i++)
        {
            int s=col[i][0];
            int d=col[i][1];
            adj.get(s).add(d);
            indeg[d]++;
        } 
        q=new ArrayDeque<>();
        for(int i=1;i<k;i++)
            if(indeg[i]==0)
                q.add(i);
         count=0;
        while(q.size()!=0)
        {
            int tmp=q.remove();
            c[tmp]=count++;
            for(int i:adj.get(tmp))
            {
                indeg[i]--;
                if(indeg[i]==0)
                    q.add(i);
            }
        }
       
        if(count<k-1)
            return new int[0][0];
        System.out.println("helle");
        for(int i=1;i<k;i++)
        {
            ans[r[i]][c[i]]=i;
        }
        return ans;
    }
}