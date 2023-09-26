//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int fnFind(int index,int nextcolor,int colors[][],int dp[][])
    {
        if(index==0)
        {
            int max=Integer.MAX_VALUE;
            for(int i=0;i<3;i++)
            {
                if(i!=nextcolor)
                max=Math.min(max,colors[index][i]);
            }
            return max;
        }
       
        if(dp[index][nextcolor]!=-1)
        return dp[index][nextcolor];
        int max=Integer.MAX_VALUE;
        for(int i=0;i<3;i++)
        {
            if(i!=nextcolor)
            {
                int val=colors[index][i]+fnFind(index-1,i,colors,dp);
                
                max=Math.min(max,val);
            }
        }
        
        return dp[index][nextcolor]=max;
    }
	int minCost(int [][] colors, int N){
	    int dp[][]=new int[N][4];
	    for(int i=0;i<N;i++)
	    {
	        for(int j=0;j<4;j++)
	        {
	            dp[i][j]=-1;
	        }
	    }
        int ans=fnFind(N-1,3,colors,dp);
        return ans;
    }
}