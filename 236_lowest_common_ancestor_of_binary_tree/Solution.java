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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return null;
        }
 
        if(root==p || root==q) {
            return root;
        }
     
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
     
        if(l!=null&&r!=null){
            return root;
        }
        else {
            return l == null? r : l;
        }
    }
    
    public TreeNode lowestCommonAncestor_slow(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        boolean left_p = contains(root.left, p);
        boolean left_q = contains(root.left, q);
        if((left_p == true && left_q == false) || (left_p == false && left_q == true)) {
            return root;     
        }
        else if(left_p == true && left_q == true) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
    
    public boolean contains(TreeNode root, TreeNode p) {
        if(root == null) {
            return false;
        }
        if(root == p) {
            return true;
        }
        if(contains(root.left, p) || contains(root.right, p)) {
            return true;
        }
        return false;
    }
}
