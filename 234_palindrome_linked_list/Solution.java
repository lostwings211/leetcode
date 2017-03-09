/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        
        int half_count = count / 2;
        if(count % 2 == 1) {
            half_count++;
        }
        
        curr = head;
        ListNode curr_forward = curr;
        int i = 0;
        while(i < half_count) {
            curr_forward = curr_forward.next;
            i++;
        }
        
        String left = "";
        String right = "";
        
        while(curr != null && curr_forward != null) {
            left = Integer.toString(curr.val) + left;
            right = right + Integer.toString(curr_forward.val);
            curr = curr.next;
            curr_forward = curr_forward.next;
        }
        return left.equals(right);
    }
}
