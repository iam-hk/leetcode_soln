class Solution {
    public int hammingDistance(int x, int y) {
        int val=x^y;
        int count=0;
        while(val!=0)
        {
            if((val&1)!=0)
                ++count;
            val>>=1;
        }
        return count;
    }
}