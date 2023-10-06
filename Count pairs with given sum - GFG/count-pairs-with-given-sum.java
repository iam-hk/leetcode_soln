//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i:arr)
        hm.put(i,hm.getOrDefault(i,0)+1);
        
        HashSet<Integer>hs=new HashSet<>();
        int res=0;
        for(int i:hm.keySet())
        {
            if(hs.contains(i))
            continue;
            if(hm.containsKey(k-i))
            {
                //System.out.println(i);
                if(i==k-i)
                {
                    res=res+(hm.get(i)*(hm.get(i)-1)/2);
                }
                else
            res=res+(hm.get(i)*hm.get(k-i));
            hs.add(k-i);
            }
        }
        return res;
    }
}
