/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   ArrayList<Integer>a1=new ArrayList<>();
    public void fnLeaf(TreeNode root)
    {
        if(root==null)
            return ;
        if(root.left==null&&root.right==null)
            a1.add(root.val);
        fnLeaf(root.left);
        fnLeaf(root.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        fnLeaf(root1);
        ArrayList<Integer>tmp=a1;
        a1=new ArrayList<>();
        fnLeaf(root2);
        int s1=0,s2=0,e1=tmp.size(),e2=a1.size();
        while(s1<e1&&s2<e2)
        {
            if(tmp.get(s1)!=a1.get(s2))
                return false;
            ++s1;
            ++s2;
        }
        if(s1<e1||s2<e2)
            return false;
        return true;
    }
}