class Solution {
    public void fnDFS(ArrayList<ArrayList<Integer>>adj,int src,boolean visited[])
    {
        visited[src]=true;
        for(int i:adj.get(src))
        {
            if(visited[i]==false)
            fnDFS(adj,i,visited);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        adj.add(new ArrayList<Integer>());
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected.length;j++)
            {
                if(i==j)
                continue;
                if(isConnected[i][j]==1)
                {
                    adj.get(i).add(j);
                }
            }

        }
        int ans=0;
        int len=isConnected.length;
        boolean visited[]=new boolean[len];
        for(int i=0;i<len;i++)
        {
            if(visited[i]==false)
            {
            fnDFS(adj,i,visited);
            ++ans;
            }
        }
        return ans;

    }
}