
    class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public void fnCombination(int arr[],List<Integer>a,int i)
    {
         
            ans.add(new ArrayList<>(a));

       for(int j=i;j<arr.length;j++)
       {
           if(j!=i&&arr[j]==arr[j-1])
               continue;
          
          
           a.add(arr[j]);
           fnCombination(arr,a,j+1);
           a.remove(a.size()-1);
       }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] arr) {
          List<Integer>a=new ArrayList<>();
        Arrays.sort(arr);
        fnCombination(arr,a,0);
        return ans;
    }
}
