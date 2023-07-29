class Solution {
    class Node{
        Node left;
        Node right;
        Node()
        {
            left=null;
            right=null;
            
        }
    }
    public void fnInsert(Node root,int num)
    {
        for(int i=0;i<32;i++)
        {
            int val=((1<<(31-i))&num)==0?0:1;
            if(val==0)
            {
                if(root.left==null)
                root.left=new Node();
                root=root.left;
            }
            else 
            {
                if(root.right==null)
                root.right=new Node();
            root=root.right;
            }
        }
    }
    public int fnQuery(Node root,int num)
    {
        int ans=0;
        for(int i=0;i<32;i++)
        {
            int bit=((1<<(31-i))&num)==0?0:1;
             int mask=(1<<(31-i));
            if(bit==0)
            {
                if(root.left!=null)
                    root=root.left;
                else 
                {
                    root=root.right;
                   
                    ans|=mask;
                }
            }
            else 
            {
                if(root.right!=null)
                {
                 ans|=mask;
                    root=root.right;
                }
                else 
                {
                    root=root.left;
                }
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        Node root=new Node();
        for(int i:nums)
            fnInsert(root,i);
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            int find=Integer.MAX_VALUE^nums[i];
            int res=fnQuery(root,find);
            System.out.println(res);
            max=Math.max(max,res^nums[i]);
        }
        return max;
    }
}