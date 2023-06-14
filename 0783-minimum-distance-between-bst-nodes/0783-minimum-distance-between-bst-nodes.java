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
    ArrayList<Integer>a=new ArrayList<>();
    public void fnInorder(TreeNode root)
    {
        if(root==null)
            return ;
        fnInorder(root.left);
        a.add(root.val);
        fnInorder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        fnInorder(root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<a.size();i++)
        {
            min=Math.min(min,a.get(i)-a.get(i-1));
        }
        return min;
    }
}