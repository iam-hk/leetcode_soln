class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public void fnSubsets(int nums[],int index,ArrayList<Integer>a)
    {
        if(index==nums.length)
        {
            if(!ans.contains(a))
                ans.add(new ArrayList<>(a));
            return ;
        }
        a.add(nums[index]);
        fnSubsets(nums,index+1,a);
        a.remove(a.size()-1);
        fnSubsets(nums,index+1,a);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer>a=new ArrayList<>();
        fnSubsets(nums,0,a);
        return ans;
    }
}