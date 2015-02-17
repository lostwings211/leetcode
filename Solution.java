public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode top = new ListNode(0);
        top.next =  head;
        
        ListNode prev = top;
        ListNode curr = head;
        ListNode next = (head != null) ? head.next : null;
        
        while(curr != null & next !=  null) {
            prev.next = next;
            ListNode tmp = next.next;
            next.next = curr;
            curr.next = tmp;
            
            prev = prev.next.next;
            curr = tmp; 
            next =  (curr != null) ? curr.next : null;
        }
        return top.next;
    }
}
