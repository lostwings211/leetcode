/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre_head = new ListNode(0);
        pre_head.next = head;
        ListNode curr_head = pre_head;
        while(curr_head.next != null) {
            if(lessthan_k_nodes(curr_head, k) == true) {
                break;
            }
            else {
                ListNode pre = curr_head;
                ListNode curr = pre.next;
                for(int i = 0; i < k; i++) {
                    ListNode next = curr.next;
                    curr.next = pre;
                    pre = curr;
                    curr = next;
                }
                ListNode new_curr_head =  curr_head.next;
                new_curr_head.next = curr;
                curr_head.next = pre;
                curr_head = new_curr_head;
            }
        }
        return pre_head.next;
    }
    
    public boolean lessthan_k_nodes(ListNode pre_head, int k) {
        int count = 0;
        while(pre_head.next != null) {
            count++;
            pre_head = pre_head.next;
        }
        return count < k;
    }
}
