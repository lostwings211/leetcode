public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null ||
            postorder == null ||
            inorder.length == 0 ||
            postorder.length == 0 ||
            inorder.length != postorder.length) {
                return null ;   
            }
        if(inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        int size = postorder.length;
        TreeNode root = new TreeNode(postorder[size-1]);
        int i = 0;
        for(i = 0; i < size; i++) {
            if(inorder[i] == postorder[size-1]) {
                break;
            }
        }
        
        int inorder_left[] = new int[i];
        int inorder_right[] = new int[size - i - 1];
        int postorder_left[] = new int[i];
        int postorder_right[] =  new int[size - i - 1];
        System.arraycopy(inorder, 0, inorder_left, 0, i);
        System.arraycopy(inorder, i + 1, inorder_right, 0, size - i - 1);
        System.arraycopy(postorder, 0, postorder_left, 0, i);
        System.arraycopy(postorder, i, postorder_right, 0, size -i - 1);
        root.left = buildTree(inorder_left, postorder_left);
        root.right = buildTree(inorder_right, postorder_right);
        return root;
    }
}
