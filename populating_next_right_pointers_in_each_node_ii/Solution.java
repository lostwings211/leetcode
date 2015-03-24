/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { 
            val = x; 
        }
    }

    public static void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode prev = root;
        prev.next = null;
        TreeLinkNode curr = null;
        boolean isleftchild = true;
        if(prev.left !=  null) {
            curr = prev.left;
        }
        else if(prev.right != null) {
            isleftchild = false;
            curr = prev.right;
        }

        TreeLinkNode prev_fix = prev;
        TreeLinkNode curr_fix = curr;

        while(curr !=  null) {
            if(isleftchild == true && prev.right !=  null) {
                isleftchild = false;
                curr.next = prev.right;
            }
            else {
                curr.next = null;
                prev = prev.next;
                while(prev != null) {
                    if(prev.left != null) {
                        isleftchild = true;
                        curr.next = prev.left;
                        break;
                    }
                    else if(prev.right != null) {
                        isleftchild = false;
                        curr.next = prev.right;
                        break;
                    }
                    prev = prev.next;
                }
            }

            if(curr.next != null) {
                curr = curr.next;
            }
            else {
                prev = curr_fix;
                curr = null;
                TreeLinkNode temp = prev;
                while(temp != null) {
                    if(temp.left != null) {
                        isleftchild = true;
                        curr = temp.left;
                        break;
                    }
                    else if(temp.right != null) {
                        isleftchild = false;
                        curr = temp.right;
                        break;
                    }
                    temp = temp.next;
                }
                prev = temp;
                prev_fix = prev;
                curr_fix =  curr;
            }
        }
    }
   
} 
