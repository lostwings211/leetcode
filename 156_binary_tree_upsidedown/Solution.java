/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        while(root != null) {
            stack.add(root);
            root = root.left;
        }
        
        TreeNode ret = null;
        TreeNode ret_curr = null;
        while(!stack.isEmpty()) {
            TreeNode curr = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            TreeNode parent = stack.size() > 0 ? stack.get(stack.size() - 1) : null;
            
            if(ret_curr == null) {
                ret_curr = new TreeNode(curr.val);
            }
            if(ret == null) {
                ret = ret_curr;
            }
            if(parent != null) {
                TreeNode ret_parent = new TreeNode(parent.val);
                TreeNode ret_right = parent.right != null ? new TreeNode(parent.right.val) : null;
                ret_curr.left = ret_right;
                ret_curr.right = ret_parent;
                ret_curr = ret_parent;
            }
            
        }
        return ret;
    }
}
