class Solution {
    public String licenseKeyFormatting(String s, int k) {
        ArrayList<Character>a=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            boolean let=false;
            if(Character.isLetter(ch)&&Character.isLowerCase(ch))
                let=true;
            if(let==true)
            {
                ch=(char)((int)ch-32);
            }
            if(ch!='-')
                a.add(ch);
        }
        if(a.size()==0)
            return "";
        int len=a.size();
        int first=0;
        if(len%k==0)
            first=k;
        else 
        first=len%k;
        
        String ans="";
        int i=0;
        for(i=0;i<first;i++)
            ans+=a.get(i);
        if(a.size()==first)
            return ans;
        ans+='-';
        int level=0;
        for(i=i;i<a.size();i++)
        {
            ans+=a.get(i);
            ++level;
            if(level==k&&i!=a.size()-1)
            {
                ans+='-';
                level=0;
            }
        }
        return ans;
    }
}