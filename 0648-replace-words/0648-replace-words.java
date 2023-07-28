class Solution {
    public class Node{
        Node childs[]=new Node[26];
        String isEnd;

    }
    public void fnInsert(Node root,String word)
    {
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(root.childs[ch-'a']==null)
            root.childs[ch-'a']=new Node();
            root=root.childs[ch-'a'];

        }
        root.isEnd=word;
    }
    public String fnSearch(String s,Node root)
    {
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(root.childs[ch-'a']==null)
                return null;
            root=root.childs[ch-'a'];
             if(root.isEnd!=null)
                return root.isEnd;
            
        }
        return null;
        
    }
    public String replaceWords(List<String> dict, String sen) {
        Node root=new Node();
        for(int i=0;i<dict.size();i++)
        {
            String tmp=dict.get(i);
            fnInsert(root,tmp);
        }
        String[]arr=sen.split(" ");
        for(int i=0;i<arr.length;i++)
        {
            String tmp=arr[i];
            String pref=fnSearch(tmp,root);
            if(pref!=null)
            arr[i]=pref;
        }
        String ans="";
        for(int i=0;i<arr.length;i++)
        if(i<arr.length-1)
        ans+=arr[i]+" ";
        else
            ans+=arr[i];
        return ans;
    }
}