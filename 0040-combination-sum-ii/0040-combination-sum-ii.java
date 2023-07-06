class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public void fnCombination(int arr[],int target,List<Integer>a,int i)
    {
        if(target==0)
        {  
            ans.add(new ArrayList<>(a));
            return;
        }
       for(int j=i;j<arr.length;j++)
       {
           if(j!=i&&arr[j]==arr[j-1])
               continue;
           if(arr[j]>target)
               break;
          
           a.add(arr[j]);
           fnCombination(arr,target-arr[j],a,j+1);
           a.remove(a.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<Integer>a=new ArrayList<>();
        Arrays.sort(arr);
        fnCombination(arr,target,a,0);
        return ans;
    }
}