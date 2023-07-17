class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
        if(rows==1&&triangle.get(0).size()==1)
        {
            return triangle.get(0).get(0);
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=rows-2;i>=0;i--)
        {
            List<Integer>l=triangle.get(i);
            List<Integer>nl=new ArrayList<>();
            if(i==rows-2)
            {
                
            for(int j=0;j<l.size();j++)
            {
                int val=l.get(j);
                int min=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                nl.add(val+min);
            }
            }
            else
            {
                List<Integer>l2=ans.get(ans.size()-1);
                for(int j=0;j<l.size();j++)
                {
                    int val=l.get(j);
                int min=Math.min(l2.get(j),l2.get(j+1));
                    nl.add(val+min);
                }
            }
            ans.add(nl);
        }
        return ans.get(ans.size()-1).get(0);
            
    }
}