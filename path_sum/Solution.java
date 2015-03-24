import java.util.*;
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        ArrayList<Integer> ret = new ArrayList<Integer>();
        dfs(root, sum, ret);
        return (ret.size() > 0);
    }
    
    public void dfs(TreeNode root, int sum, ArrayList<Integer> ret) {
        TreeNode curr = root;
        if(curr.left == null && curr.right == null) {
            if(sum == curr.val) {
                ret.add(1);
                return;
            }
        }
        if(curr.left !=  null) {
            dfs(curr.left, sum - curr.val, ret);
        }
        if(ret.size() > 0) {
            return;
        }
        if(curr.right !=  null) {
            dfs(curr.right, sum - curr.val, ret);
        }
    }
}
