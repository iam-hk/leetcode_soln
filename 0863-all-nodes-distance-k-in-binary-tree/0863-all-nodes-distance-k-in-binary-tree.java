/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void fnParent(TreeNode root,HashMap<Integer,TreeNode>hm)
    {
        if(root==null)
            return;
        if(root.left!=null)
            hm.put(root.left.val,root);
        if(root.right!=null)
            hm.put(root.right.val,root);
        fnParent(root.left,hm);
        fnParent(root.right,hm);
    }
    public void fnVisited(TreeNode root,HashMap<Integer,Boolean>hm)
    {
        if(root==null)
            return;
        hm.put(root.val,false);
        fnVisited(root.left,hm);
        fnVisited(root.right,hm);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>ans =new ArrayList<>();
        HashMap<Integer,TreeNode>parent=new HashMap<>();
        fnParent(root,parent);
        HashMap<Integer,Boolean>vis=new HashMap<>();
        fnVisited(root,vis);
        Queue<TreeNode>q=new ArrayDeque<>();
        q.add(target);
        vis.put(target.val,true);
        int level=0;
        while(q.size()!=0)
        {
            int size=q.size();
            if(level==k)
            {
                for(int i=0;i<size;i++)
                {
                    TreeNode tmp=q.remove();
                    ans.add(tmp.val);
                }
                return ans;
            }
            else 
            {
                for(int i=0;i<size;i++)
                {
                TreeNode tmp=q.remove();
                if(tmp.left!=null&&vis.get(tmp.left.val)==false)
                {
                    q.add(tmp.left);
                    vis.put(tmp.val,true);
                }
                if(tmp.right!=null&&vis.get(tmp.right.val)==false)
                {
                    
                    vis.put(tmp.val,true);
                    q.add(tmp.right);
                }
                TreeNode par=parent.get(tmp.val);
                if(par!=null&&vis.get(par.val)==false)
                {
                    q.add(par);
                    vis.put(par.val,true);
                }
                }
                
            }
            ++level;
        }
        return ans;
    }
}