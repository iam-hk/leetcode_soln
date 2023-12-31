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
    int max=Integer.MIN_VALUE;
    public void fnDFS(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {
            max=Math.max(max,level);
        }
        fnDFS(root.left,level+1);
        fnDFS(root.right,level+1);
        
    }
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        fnDFS(root,1);
        return max;
    }
}