class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        boolean cycle=false;
        int count=0;
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int arr[]=fnNext(cells);
            String s=Arrays.toString(arr);
            if(!hs.contains(s))
            {
                hs.add(s);
            }
            else 
            {
                cycle=true;
                break;
            }
            ++count;
            cells=arr;
        }
        if(cycle==true)
        {
            n%=count;
            for(int i=0;i<n;i++)
            {
                cells=fnNext(cells);
            }
        }
        return cells;
    }
    public int[]fnNext(int cell[])
    {
        int arr[]=new int[cell.length];
        for(int i=1;i<cell.length-1;i++)
        {
            arr[i]=cell[i-1]==cell[i+1]?1:0;
        }
        return arr;
    }
}