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

    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ArrayList<TreeNode> nodes =  new ArrayList<TreeNode>();
        nodes.add(root);
        int i = 0;
        
        while(i < nodes.size()) {
            int curr = i;
            for(int index = curr; index < nodes.size(); index++) {
                if(nodes.get(index).left != null) {
                    nodes.add(nodes.get(index).left);
                }
                if(nodes.get(index).right != null) {
                    nodes.add(nodes.get(index).right);
                }
                i++;
            }
        }
        int global_max = Integer.MIN_VALUE;
        HashMap<TreeNode, Integer> dp =  new HashMap<TreeNode, Integer>();
        dp.put(null, 0);
        
        for(int index = nodes.size() - 1; index >= 0; index--) {
            TreeNode curr_node = nodes.get(index);
            int max =  Math.max(Math.max(curr_node.val + dp.get(curr_node.left), curr_node.val + dp.get(curr_node.right)), curr_node.val);
            dp.put(curr_node, max);
            
            int temp = Math.max(max,  curr_node.val + dp.get(curr_node.left) + dp.get(curr_node.right));
            if( temp > global_max) {
                global_max = temp;
            }
        }
        return global_max;
    }
}
