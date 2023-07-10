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
    public int fnMin(TreeNode root)
    {
        int ht=-1;
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int r=fnMin(root.right);
        int l=fnMin(root.left);
       
        if(root.left==null)
        return r+1;
        if(root.right==null)
        return l+1;
        return Math.min(l,r)+1;
    }
    public int minDepth(TreeNode root) {
        int ht=fnMin(root);
        return ht;
    }
}