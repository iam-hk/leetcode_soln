class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public void fnCombination(int []arr,int target,ArrayList<Integer>a,int i)
    {
        if(target==0)
         {
           ans.add(new ArrayList<>(a));
           return;
         }
       if(i==arr.length)
       {
          return;
       }
        if(target<0)         
            return ;
        target-=arr[i];
        a.add(arr[i]);
        fnCombination(arr,target,a,i);
        a.remove(Integer.valueOf(arr[i]));
        target+=arr[i];
        fnCombination(arr,target,a,i+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<Integer>a=new ArrayList<>();
        fnCombination(candidates,target,a,0);
        return ans;
    }
}