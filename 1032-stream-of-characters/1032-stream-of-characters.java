class StreamChecker {
    class Node{
        Node childs[]=new Node[26];
        boolean isEnd;
    }
    final Node root;
    public void fnInsert(String s,Node root)
    {
        Node curr=root;
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(curr.childs[ch-'a']==null)
                curr.childs[ch-'a']=new Node();
            curr=curr.childs[ch-'a'];
            
        }
        curr.isEnd=true;
    }
    
    public StreamChecker(String[] words) {
        root=new Node();
        for(String s:words)
        {
            fnInsert(s,root);
        }
        
    }
    StringBuilder sb=new StringBuilder();
    public boolean query(char letter) {
        Node curr=root;
        sb.append(letter);
        for(int i=sb.length()-1;i>=0;i--)
        {
            char ch=sb.charAt(i);
            if(curr.childs[ch-'a']==null)
                return false;
            curr=curr.childs[ch-'a'];
            if(curr.isEnd)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */