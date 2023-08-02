class Solution {
    public void fnPerm(int nums[],List<Integer>a,List<List<Integer>>ans,int n,boolean visited[])
    {
       if(a.size()==n)
       {
           ans.add(new ArrayList<>(a));
           return ;
           
       }
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                a.add(nums[i]);
                visited[i]=true;
                fnPerm(nums,a,ans,n,visited);
                visited[i]=false;
                a.remove(a.size()-1);
                
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        boolean visited[]=new boolean [nums.length];
        fnPerm(nums,a,ans,nums.length,visited);
        return ans;
    }
}