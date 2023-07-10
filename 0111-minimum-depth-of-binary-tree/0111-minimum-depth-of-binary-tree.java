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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        int depth=1;
        while(q.size()!=0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode tmp=q.remove();
                if(tmp.left==null&&tmp.right==null)
                    return depth;
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
            ++depth;
        }
        return 0;
    }
}