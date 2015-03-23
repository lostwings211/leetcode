public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if(num ==  null || num.length == 0) {
            return null;
        }
        if(num.length == 1) {
            return new TreeNode(num[0]);
        }
        int half = num.length / 2;
        TreeNode root = new TreeNode(num[half]);
        int num_left[] =  new int[half];
        int num_right[] = new int[num.length - half - 1];
        System.arraycopy(num, 0, num_left, 0, half);
        System.arraycopy(num, half + 1, num_right, 0, num.length - half - 1);
        root.left = sortedArrayToBST(num_left);
        root.right = sortedArrayToBST(num_right);
        return root;
    }
}
