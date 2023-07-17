//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static void fnDFS(int arr[][],int n,ArrayList<String>ans,String tmp,int row,int col,boolean [][]visited)
    {
        if(row==n-1&&col==n-1)
        {
            ans.add(tmp);
            return ;
        }
        if(row-1>=0&&!visited[row-1][col]&&arr[row-1][col]==1)
        {
            tmp+='U';
            visited[row-1][col]=true;
            fnDFS(arr,n,ans,tmp,row-1,col,visited);
            tmp=tmp.substring(0,tmp.length()-1);
            visited[row-1][col]=false;
            
        }
        if(row+1<n&&!visited[row+1][col]&&arr[row+1][col]==1)
        {
            tmp+='D';
            visited[row+1][col]=true;
            fnDFS(arr,n,ans,tmp,row+1,col,visited);
            tmp=tmp.substring(0,tmp.length()-1);
            visited[row+1][col]=false;
        }
        if(col-1>=0&&!visited[row][col-1]&&arr[row][col-1]==1)
        {
          tmp+='L';
            visited[row][col-1]=true;
            fnDFS(arr,n,ans,tmp,row,col-1,visited);
            tmp=tmp.substring(0,tmp.length()-1);
            visited[row][col-1]=false;   
        }
        if(col+1<n&&!visited[row][col+1]&&arr[row][col+1]==1)
        {
          tmp+='R';
            visited[row][col+1]=true;
            fnDFS(arr,n,ans,tmp,row,col+1,visited);
            tmp=tmp.substring(0,tmp.length()-1);
            visited[row][col+1]=false;   
        }
        
        
    }
    public static ArrayList<String> findPath(int[][] arr, int n) {
        // Your code here
        ArrayList<String>ans=new ArrayList<>();
        if(arr[0][0]==0||arr[n-1][n-1]==0)
        {
            ans.add("-1");
            return ans;
        }
        boolean visited[][]=new boolean[n][n];
        visited[0][0]=true;
        fnDFS(arr,n,ans,"",0,0,visited);
        return ans;
        
    }
}