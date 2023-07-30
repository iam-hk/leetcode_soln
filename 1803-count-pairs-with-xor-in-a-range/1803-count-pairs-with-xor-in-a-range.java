class Solution {
    class Node
    {
        Node left;
        Node right;
        int count=0;
        Node ()
        {
            left=null;
            right=null;
            count=0;
        }
    }
    public int getCount(Node root)
    {
        return  root==null?0:root.count;
    }
    final int max_bit=14;
    public int query(Node root,int high,int val,int index)
    {
        if(root==null)
            return 0;
        if(index==-1)
            return getCount(root);
        int bitVal=((1<<index)&val)>0?1:0;
        int bitHigh=((1<<index)&high)>0?1:0;
        if(bitVal==0)
        {
            if(bitHigh==0)
            {
                return query(root.left,high,val,index-1);
            }
            else
            {
                return getCount(root.left)+query(root.right,high,val,index-1);
            }
        }
        else
        {
            if(bitHigh==0)
            {
                return query(root.right,high,val,index-1);
            }
            else 
            {
                return query(root.left,high,val,index-1)+getCount(root.right);
            }
        }
    }
    public void insert(Node root,int val)
    {
        for(int i=14;i>=0;i--)
        {
            int dig=((1<<i)&val)==0?0:1;
            if(dig==0)   
            {
                if(root.left==null)
                {
                    root.left=new Node();
                    
                }
                root=root.left;
                
            }
            else 
            {
                if(root.right==null)
                    root.right=new Node();
                root=root.right;
                
            }
            root.count++;
        }
    }
        
    public int countPairs(int[] nums, int low, int high) {
        Node root=new Node();
        int count=0;
        for(int val:nums)
        {
            count+=query(root,high,val,max_bit);
            //System.out.println(count);
            count-=query(root,low-1,val,max_bit);
            //System.out.println(count);
            insert(root,val);
        }
        return count;
    }
}