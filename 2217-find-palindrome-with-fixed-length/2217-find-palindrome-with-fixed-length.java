class Solution {
    public long[] kthPalindrome(int[] arr, int len) {
        long ans[]=new long[arr.length];
        int half=(len+1)/2;
        
        int v=((int)Math.pow(10,half)-1)-((int)Math.pow(10,half-1))+1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>v)
                ans[i]=-1;
            else
            {
            long val=(int)Math.pow(10,half-1);
            val+=arr[i]-1;
            
            String s=Long.toString(val);
            String rev="";
            if(len%2==1)
            {
                rev=fnRev(s.substring(0,s.length()-1));
            }
            else 
                rev=fnRev(s);
            s+=rev;
            long a=Long.parseLong(s);
            ans[i]=a;
            }
        }
        return ans;
    }
    public String fnRev(String s)
    {
        String ans="";
        for(int i=s.length()-1;i>=0;i--)
            ans+=s.charAt(i);
        return ans;
    }
}