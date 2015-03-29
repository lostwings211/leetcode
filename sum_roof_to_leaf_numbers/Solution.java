public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        int sum[] =  new int[1];
        if(root == null) {
            return 0;
        }
        dfs(root, 0, sum);
        return sum[0];
    }
    
    public void dfs(TreeNode root, int item, int[] sum) {
        if(root.left == null && root.right == null) {
            int curr = 10 * item + root.val;
            sum[0] += curr;
            return;
         }
         
         if(root.left != null) {
             int curr = 10 * item + root.val;
             dfs(root.left, curr, sum);
         }
         if(root.right != null) {
             int curr = 10 * item + root.val;
             dfs(root.right, curr, sum);
         }
    }
}
