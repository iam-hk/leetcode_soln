class Solution {
   public void fnPermute(int []arr,boolean visited[],List<List<Integer>>ans,List<Integer>a)
    {
        
        for(int i=0;i<arr.length;i++)
        {
            if(a.size()==arr.length)
            {
                ans.add(new ArrayList<>(a));
                return;
            }
            if(!visited[i])
            {
                visited[i]=true;
                a.add(arr[i]);
                fnPermute(arr,visited,ans,a);
                visited[i]=false;
                a.remove(a.size()-1);
                
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean visited[]=new boolean[nums.length];
        List<Integer>a=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        fnPermute(nums,visited,ans,a);
        return ans;
    }
}