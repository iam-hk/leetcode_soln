class Solution {
    public void fnPermute(int []arr,int index,List<List<Integer>>ans)
    {
         if(index==arr.length)
         {
          List<Integer>a=new ArrayList<>();
             for(int j:arr)
                 a.add(j);
         ans.add(new ArrayList<>(a));
          return;
         }
        for(int i=index;i<arr.length;i++)
        {
           swap(i,index,arr);
            fnPermute(arr,index+1,ans);
            swap(i,index,arr);
        }
    }
    private void swap(int i,int j,int arr[])
    {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        for(int i:nums)
            a.add(i);
        fnPermute(nums,0,ans);
        return ans;
            
    }
}

// class Solution {
//     private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
//         if(index == nums.length) {
//             // copy the ds to ans
//             List<Integer> ds = new ArrayList<>();
//             for(int i = 0;i<nums.length;i++) {
//                 ds.add(nums[i]); 
//             }
//             ans.add(new ArrayList<>(ds)); 
//             return; 
//         }
//         for(int i = index;i<nums.length;i++) {
//             swap(i, index, nums); 
//             recurPermute(index+1, nums, ans); 
//             swap(i, index, nums); 
//         }
//     }
//     private void swap(int i, int j, int[] nums) {
//         int t = nums[i]; 
//         nums[i] = nums[j]; 
//         nums[j] = t;
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>(); 
//         recurPermute(0, nums, ans);
//         return ans; 
//     }
// }