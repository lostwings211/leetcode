public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left != null && root.val <= max_tree(root.left)) {
            return false;
        }
        if(root.right != null && root.val >= min_tree(root.right)) {
            return false;
        }
        if(isValidBST(root.left) && isValidBST(root.right)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int min_tree(TreeNode root) {
        TreeNode curr = root;
        while(curr.left != null) {
            curr = curr.left; 
        }
        return curr.val;
    }
    
    public int max_tree(TreeNode root) {
        TreeNode curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }
}
