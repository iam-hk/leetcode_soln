class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length,ans=0;
        HashMap<ArrayList<Integer>,Integer>hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer>a=new ArrayList<>();
    
            for(int j=0;j<n;j++)
            {
              a.add(grid[i][j]);
              
            }
            hm.put(a,hm.getOrDefault(a,0)+1);
        }
        
        for(int j=0;j<n;j++)
        {
            int check=0;
            ArrayList<Integer>a=new ArrayList<>();
            for(int k=0;k<n;k++)
            {
                a.add(grid[k][j]);

            }
            if(hm.containsKey(a))
            ans+=hm.get(a);
        }
        
        return ans;
    }
}