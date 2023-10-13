//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        // Your code here
        int arr[]=new int[26];
        Arrays.fill(arr,-1);
        for(int i=0;i<patt.length();i++)
        {
            char ch=patt.charAt(i);
            
            
            if(arr[ch-'a']==-1)
            {
               
            arr[ch-'a']=i;
            }
        }
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(arr[ch-'a']>=0)
            return i;
        }
        return -1;
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		}
	}
}

// } Driver Code Ends