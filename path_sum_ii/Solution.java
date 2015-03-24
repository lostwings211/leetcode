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

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return ret;
        }
        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(root, sum, item, ret);
        return ret;
    }
    
    public void dfs(TreeNode root, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> ret) {
        if(root.left == null && root.right == null) {
            if(root.val == sum) {
                ArrayList<Integer> new_item = new ArrayList<Integer>(item);
                new_item.add(root.val);
                ret.add(new_item);
            }
            return;
        }
        if(root.left != null) {
            item.add(root.val);
            dfs(root.left, sum - root.val, item, ret);
            item.remove(item.size() - 1);
        }
        if(root.right !=  null) {
            item.add(root.val);
            dfs(root.right, sum - root.val, item, ret);
            item.remove(item.size() - 1);
        }
    }
}
