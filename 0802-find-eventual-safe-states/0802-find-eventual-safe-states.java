class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
            adj.add(new ArrayList<Integer>());
        List<Integer>ans=new ArrayList<>();
        int indeg[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            int s=i;
            for(int j=0;j<graph[i].length;j++)
            {
                int d=graph[i][j];
                adj.get(d).add(s);
                indeg[i]++;
            }
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<graph.length;i++)
            if(indeg[i]==0)
                q.add(i);
        while(q.size()!=0)
        {
            int tmp=q.remove();
            ans.add(tmp);
            for(int i:adj.get(tmp))
            {
                indeg[i]--;
                if(indeg[i]==0)
                    q.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}