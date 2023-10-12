//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution ob = new  Solution();
	        
	        List <List<String>> ans = ob.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] strs) 
    {
        // Code here
         HashMap<HashMap<Character,Integer>,ArrayList<String>>bigmap=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            String s=strs[i];
            HashMap<Character,Integer>s1=new HashMap<>();
            for(int j=0;j<s.length();j++)
                s1.put(s.charAt(j),s1.getOrDefault(s.charAt(j),0)+1);
            if(bigmap.containsKey(s1))
            {
                ArrayList<String>a=bigmap.get(s1);
                a.add(s);
                bigmap.put(s1,a);
            }    
            else 
            {
                ArrayList<String>a=new ArrayList<>();
                a.add(s);
                bigmap.put(s1,a);
            }
        }
        List<List<String>>ans=new ArrayList<>();
        
        for(List<String>tmp:bigmap.values())
        {
            //List<String>t=tmp;
            //Collections.sort(t);
            ans.add(tmp);
        }
        return ans;
    
    }
}
