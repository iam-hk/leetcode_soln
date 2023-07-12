class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public void fnPermute(int nums[],boolean visited[],List<Integer>a)
    {
        if(a.size()==nums.length)
            {
                ans.add(new ArrayList<>(a));
                return ;
            }
        
        for(int i=0;i<nums.length;i++)
        {
            
            if(!visited[i])
            {
                a.add(nums[i]);
                visited[i]=true;
                fnPermute(nums,visited,a);
                visited[i]=false;
                a.remove(a.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean visited[]=new boolean[nums.length];
        List<Integer>a=new ArrayList<>();
        
        fnPermute(nums,visited,a);
        return ans;
    }
}