class Solution {
    public int numUniqueEmails(String[] emails) {
        int count=0;
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<emails.length;i++)
        {
            String s=emails[i];
            String tmp="";
            boolean at=false,plus=false;
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                if(at==false)
                {
                if(ch=='.'&&at==false)
                {
                    continue;
                }
                
                
                if(ch=='+')
                    plus=true;
                if(plus==true)
                {
                    if(ch!='@')
                        continue;
                    else 
                    {
                        plus=false;
                        
                    }
                }
                }
                if(ch=='@')
                    at=true;
                 tmp+=ch; 
                
            }
            //System.out.println(tmp);
            hs.add(tmp);
        }
        return hs.size();
    }
}