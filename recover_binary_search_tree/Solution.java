public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }
   
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    
    public void recoverTree(TreeNode root) {
        inorder_traverse(root);
        if(first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    public void inorder_traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder_traverse(root.left);
        if(prev !=  null) {
            if(root.val <= prev.val) {
                if(first == null) {
                    first = prev;
                }
                second = root;
            }
        }   
        prev = root;
        inorder_traverse(root.right);
    }
}
