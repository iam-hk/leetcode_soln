//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ////Recursive solution
  
   public static boolean fnFind(HashSet<String>hs,String a)
    {
        if(a.length()==0)
        return true;
        
        for(int i=0;i<a.length();i++)
        {
            String tmp=a.substring(0,i+1);
            if(hs.contains(tmp))
            {
                boolean k=fnFind(hs,a.substring(i+1));
                if(k==true)
                return true;
            }
            
        }
        return false;
    }

    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
    
        HashSet<String>hs=new HashSet<>();
        for(String s:B)
        hs.add(s);
        if(fnFind(hs,A))
        return 1;
        return 0;
    }
}

  