/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i = 0; i < n % count; i++) {
            fast = fast.next;
        }
        
        while(fast.next !=  null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        if(slow.next == null) {
            return head;
        }
        ListNode new_head = slow.next;
        slow.next =  null;
        fast.next = head;
        return new_head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

}
