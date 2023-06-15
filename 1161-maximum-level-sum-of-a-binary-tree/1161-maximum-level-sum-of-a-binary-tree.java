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
    
    public int fnLevelOrder(TreeNode root)
    {
        int sum=root.val;
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(root);
        int level=1,ans=1;
        while(q.size()!=0)
        {
            int c_sum=0;
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                TreeNode tmp=q.remove();
                c_sum+=tmp.val;
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
            }
            
            if(c_sum>sum)
            {
                sum=c_sum;
                ans=level;
            }
            ++level;
        }
        return ans;
    }
    public int maxLevelSum(TreeNode root) {
       return fnLevelOrder(root);
    }
}