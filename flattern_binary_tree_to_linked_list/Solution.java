public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public void flatten(TreeNode root) {
        Convert(root);
    }
    
    public TreeNode Convert(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        TreeNode ret = null;
        if(root.left != null) {
            TreeNode curr_right = root.right;
            TreeNode last_left = Convert(root.left);
            root.right = root.left;
            root.left = null;
            last_left.right = curr_right;
            if(curr_right != null) {
                ret = Convert(curr_right);
            }
            else {
                ret = last_left;
            }
        }
        if(root.left == null) {
            ret = Convert(root.right);
        }
        return ret;
    }
}
