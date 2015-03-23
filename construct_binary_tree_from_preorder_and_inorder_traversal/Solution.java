public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || 
            inorder == null || 
            preorder.length == 0 || 
            inorder.length == 0 || 
            preorder.length != inorder.length )  {
            return null;
        }
        if(preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for(i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]) {
                break;
            }
        }
        
        int preorder_left[] = new int[i];
        int preorder_right[] = new int[inorder.length - i -1];
        int inorder_left[] =  new int[i];
        int inorder_right[] = new int[inorder.length - i -1];
        System.arraycopy(inorder, 0, inorder_left, 0, i);
        System.arraycopy(inorder, i + 1, inorder_right, 0, inorder.length - i -1);
        System.arraycopy(preorder, 1, preorder_left, 0, i);
        System.arraycopy(preorder, i + 1, preorder_right, 0, inorder.length - i -1);
        root.left = buildTree(preorder_left, inorder_left);
        root.right = buildTree(preorder_right, inorder_right);
    
        return root;
    }
}
