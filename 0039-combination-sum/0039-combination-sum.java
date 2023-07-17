class Solution {
    public void fnComb(int arr[],int ind,List<List<Integer>>ans,List<Integer>a,int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(a));
            return ;
            
        }
        if(ind==arr.length||target<0)
            return;
        a.add(arr[ind]);
        fnComb(arr,ind,ans,a,target-arr[ind]);
        a.remove(a.size()-1);
        fnComb(arr,ind+1,ans,a,target);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        fnComb(arr,0,ans,a,target);
        return ans;
    }
}