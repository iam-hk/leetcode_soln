public class Pair{
    char c;
    int count;
    Pair(char c,int count)
    {
        this.c=c;
        this.count=count;
    }
}
class Solution {

    public String removeDuplicates(String ss, int k) {
        Stack<Pair>s=new Stack<>();
        
            int check=0;
        for(int i=0;i<ss.length();i++)
        {
            char ch=ss.charAt(i);
            if(s.size()==0)
            {
                s.push(new Pair(ch,1));
            }
            else
            {
            Pair tmp=s.peek();
            if(tmp.c==ch)
            {
                s.pop();
                tmp.count++;
                
                s.push(new Pair(tmp.c,tmp.count));
            }
            else
            {
                s.push(new Pair(ch,1));
            }
            if(tmp.count==k)
            {
                System.out.println(s.peek().count);
                s.pop();
                check=1;
            }
        }
        }
        
        String ans="";
        while(s.size()!=0)
        {
            Pair tmp=s.pop();
            for(int i=0;i<tmp.count;i++)
                ans=tmp.c+ans;
        }
        return  ans;
    }
}