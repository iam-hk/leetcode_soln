class Solution {
    public void fnComb(int arr[],int tar,List<List<Integer>>ans,List<Integer>a,int index)
    {
        if(tar==0)
        {
            ans.add(new ArrayList<>(a));
            return ;
        }
        if(index==arr.length||tar<0)
        {
            return ;
            
        }
        a.add(arr[index]);
        fnComb(arr,tar-arr[index],ans,a,index);
        a.remove(a.size()-1);
        fnComb(arr,tar,ans,a,index+1);
    }
    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        fnComb(arr,tar,ans,a,0);
        return ans;
    }
}