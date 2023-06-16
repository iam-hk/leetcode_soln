class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            int val=0;
            for(int j=n-1;j>=0;j--)
            {
                arr[i][val++]=image[i][j];
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                if(arr[i][j]==1)
                    arr[i][j]=0;
                else 
                    arr[i][j]=1;
        }
        return arr;
    }
}