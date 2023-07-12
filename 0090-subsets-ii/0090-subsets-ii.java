class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public void fnSubset(int arr[],List<Integer>a,int index)
    {
        ans.add(new ArrayList<>(a));
        for(int i=index;i<arr.length;i++)
        {
            if(i!=index&&arr[i]==arr[i-1])
                continue;
            a.add(arr[i]);
            fnSubset(arr,a,i+1);
            a.remove(a.size()-1);
            
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer>a=new ArrayList<>();
        fnSubset(nums,a,0);
        return ans;
    }
}