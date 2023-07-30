class Solution {
    class Node {
        Node childs[]=new Node[26];
        boolean isEnd;
    }
    public void fnInsert(Node root,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(root.childs[ch-'a']==null)
                root.childs[ch-'a']=new Node();
            root=root.childs[ch-'a'];
            
        }
        root.isEnd=true;
    }
    public boolean fnFind(Node root,String s)
    {
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            root=root.childs[ch-'a'];
            if(!root.isEnd)
            {
                return false;    
            }
            
        }
        return true;
        
    }
    public String longestWord(String[] words) {
        Node root=new Node();
        for(int i=0;i<words.length;i++)
        {
            String s=words[i];
            fnInsert(root,s);
        }
        String ans="";
        for(int i=0;i<words.length;i++)
        {
            boolean k=fnFind(root,words[i]);
            if(k==true)
            {
                if(ans.length()<words[i].length())
                    ans=words[i];
                else if(ans.length()==words[i].length())
                {
                    if(ans.compareTo(words[i])>0)
                        ans=words[i];
                }
            }
        }
        return ans;
    }
}