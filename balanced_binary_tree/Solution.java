public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(height(root.left) + 1, height(root.right) + 1);
    }
}
