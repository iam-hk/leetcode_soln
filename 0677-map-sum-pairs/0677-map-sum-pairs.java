class MapSum {
    class Node {
        Node childs[]=new Node[26];
        int count=0;
    }
    Map<String,Integer> hm;
    Node head;
    public MapSum() {
        hm=new HashMap<>();
        head=new Node();
    }
    
    public void insert(String key, int val) {
        int diff=0;
        Node root=head;
        if(hm.containsKey(key))
        {
            diff=val-hm.get(key);
               
        }
        hm.put(key,val);
        for(int i=0;i<key.length();i++)
        {
            char ch=key.charAt(i);
            if(root.childs[ch-'a']==null)
                root.childs[ch-'a']=new Node();
            root=root.childs[ch-'a'];
            if(diff!=0)
            root.count+=diff;
            else 
                root.count+=val;
        }
    }
    
    public int sum(String prefix) {
        Node root=head;
        for(int i=0;i<prefix.length();i++)
        {
            char ch=prefix.charAt(i);
            if(root.childs[ch-'a']==null)
                return 0;
            root=root.childs[ch-'a'];
            
        }
        return root.count;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */