/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode convertBST(TreeNode root) {
        ArrayList<Integer> values = inorder_traversal(root);
        int sum = 0;
        for(int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < values.size(); i++) {
            int curr_val = values.get(i);
            sum = sum - curr_val;
            map.put(curr_val, sum);
        }
        inorder_traversal_change(root, map);
        return root;
    }
    
    public void inorder_traversal_change(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) {
            return;
        }
        inorder_traversal_change(root.left, map);
        root.val = root.val + map.get(root.val);
        inorder_traversal_change(root.right, map);
    }
    
    public ArrayList<Integer> inorder_traversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }
        ArrayList<Integer> left_tree = inorder_traversal(root.left);
        ArrayList<Integer> right_tree = inorder_traversal(root.right);
        for(Integer curr : left_tree) {
            ret.add(curr);
        }
        ret.add(root.val);
        for(Integer curr : right_tree) {
            ret.add(curr);
        }
        return ret;
    }
}
