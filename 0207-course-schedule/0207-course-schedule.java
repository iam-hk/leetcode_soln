class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>());
        int indeg[]=new int[numCourses];
        for(int i=0;i<pre.length;i++)
        {
            int dep=pre[i][0];
            int indep=pre[i][1];
            adj.get(indep).add(dep);
            indeg[dep]++;
        }
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
            if(indeg[i]==0)
                q.add(i);
        while(q.size()!=0)
        {
            int tmp=q.remove();
            for(int i:adj.get(tmp))
            {
                indeg[i]--;
                if(indeg[i]==0)
                    q.add(i);
            }
        }
        for(int i=0;i<indeg.length;i++)
            if(indeg[i]!=0)
            return false;
        return true;
            }
}