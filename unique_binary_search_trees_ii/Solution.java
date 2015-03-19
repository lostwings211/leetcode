import java.util.*;
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
            left = null; 
            right = null; 
        }
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }
    
    public ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if(start > end) {
            ret.add(null);
        }
        else if(start == end) {
            ret.add(new TreeNode(start));
        }
        else {
            for(int i = start; i <= end; i++) {
                ArrayList<TreeNode> left_children = dfs(start, i - 1);
                ArrayList<TreeNode> right_children = dfs(i + 1, end);
                for(TreeNode curr_left : left_children) {
                    for(TreeNode curr_right : right_children) {
                        TreeNode root = new TreeNode(i);
                        root.left = curr_left;
                        root.right = curr_right;
                        ret.add(root);
                    }
                }
            }
        }
        return ret;
    }
}
