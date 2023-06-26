class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer>s=new Stack<>();
        int n=num.length();
        if(n==k)
            return "0";
        for(int i=0;i<n;i++)
        {
            int val=num.charAt(i)-'0';
            while(s.size()!=0&&val<s.peek()&&k>0)
            {
                s.pop();  
                --k;
            }
             s.push(val);
        }
        while(k--!=0)
        {
            s.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(s.size()!=0)
        {
            int val=48+s.pop();
            char ch=(char)val;
            sb.append(ch);
        }
        sb=sb.reverse();
        int i=0;
        
        String ans=sb.toString();
        for(i=0;i<ans.length();i++)
            if(ans.charAt(i)!='0')
                break;
        if(i>=ans.length())
            return "0";
        ans=ans.substring(i);
        if(ans.equals(""))
            ans="0";
        return ans;
    }
}