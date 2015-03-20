import java.util.*;
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        if(root.left == null || root.right == null) {
            return false;
        }
        ArrayList<TreeNode> left_nodes = new ArrayList<TreeNode>();
        ArrayList<TreeNode> right_nodes = new ArrayList<TreeNode>();
        left_nodes.add(root.left);
        right_nodes.add(root.right);
        while(left_nodes.size() > 0 || right_nodes.size() > 0) {
            if(left_nodes.size() != right_nodes.size()) {
                return false;
            }
            int size = left_nodes.size();
            ArrayList<TreeNode> left_nodes_temp = new ArrayList<TreeNode>();
            ArrayList<TreeNode> right_nodes_temp = new ArrayList<TreeNode>();
            for(int i = 0; i < size; i++) {
                if( (left_nodes.get(i).val != right_nodes.get(size - 1 - i).val) ||
                    (left_nodes.get(i).left != null && right_nodes.get(size - 1 - i).right == null) ||
                    (left_nodes.get(i).right != null && right_nodes.get(size - 1 - i).left == null) || 
                    (left_nodes.get(i).left == null && right_nodes.get(size - 1 - i).right != null) ||
                    (left_nodes.get(i).right == null && right_nodes.get(size - 1 - i).left != null)){
                    return false;
                }
                else {
                    if(left_nodes.get(i).left !=  null) {
                        left_nodes_temp.add(left_nodes.get(i).left);
                    }
                    if(left_nodes.get(i).right !=  null) {
                        left_nodes_temp.add(left_nodes.get(i).right);
                    }
                    if(right_nodes.get(i).left !=  null) {
                        right_nodes_temp.add(right_nodes.get(i).left);
                    }
                    if(right_nodes.get(i).right !=  null) {
                        right_nodes_temp.add(right_nodes.get(i).right);
                    }
                }
            }
            left_nodes = left_nodes_temp;
            right_nodes = right_nodes_temp;
        }
        return true;
    }
}
