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
    ArrayList<Integer>ans=new ArrayList<>();
    public void fnInorder(TreeNode root)
    {
        if(root==null)
        return;
        fnInorder(root.left);
        ans.add(root.val);
        fnInorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        fnInorder(root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<ans.size();i++)
        {
            min=Math.min(min,ans.get(i)-ans.get(i-1));
        }
        return min;
    }
}