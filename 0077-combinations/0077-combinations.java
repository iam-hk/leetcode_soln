class Solution {
    public void fnComb(int n,int k,List<List<Integer>>ans,List<Integer>a,boolean visited[],int val)
    {
        if(a.size()==k)
        {
            ans.add(new ArrayList<>(a));
            return ;
        }
        for(int i=val;i<=n;i++)
        {
            if(!visited[i])
            {
            a.add(i);
                visited[i]=true;
            fnComb(n,k,ans,a,visited,i);
            a.remove(a.size()-1);
                visited[i]=false;
            }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        boolean visited[]=new boolean[n+1];
        fnComb(n,k,ans,a,visited,1);
        return ans;
    }
}