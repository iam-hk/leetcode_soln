class Solution {
    public void fnComb(int arr[],int tar,List<List<Integer>>ans,List<Integer>a,int index)
    {
        if(tar==0)
        {
            ans.add(new ArrayList<Integer>(a));
            return ;
        }
        if(index==arr.length)
            return;
    
    for(int i=index;i<arr.length;i++)
    {
        if(i!=index&&arr[i]==arr[i-1])
            continue;
        if(tar<0)
            break;
        a.add(arr[i]);
        fnComb(arr,tar-arr[i],ans,a,i+1);
        a.remove(a.size()-1);
        
    }
    }
    public List<List<Integer>> combinationSum2(int[] arr, int tar) {
                List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(arr);
        List<Integer>a=new ArrayList<>();
        fnComb(arr,tar,ans,a,0);
        return ans;   
    }
}