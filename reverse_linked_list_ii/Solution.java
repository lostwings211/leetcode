public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode pre_curr =  new ListNode(0);
        pre_curr.next = curr;
        ListNode pre_head = pre_curr;
        
        for(int i = 1; i < m; i++) {
            pre_curr = curr;
            curr =  curr.next;
        }
        ListNode pre_m_node = pre_curr;
        ListNode m_node = curr;
        for(int i = 0; i <= n - m; i++) {
            ListNode next = curr.next;
            curr.next = pre_curr;
            pre_curr = curr;
            curr = next;
        }
        m_node.next = curr;
        pre_m_node.next = pre_curr;
        return pre_head.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode curr =  head;
        ListNode pre_curr = new ListNode(0);
        pre_curr.next = curr;
        
        while(curr.next != null) {
            ListNode next = curr.next;
            if(curr == head) {
                curr.next =  null;
            }
            else {
                curr.next = pre_curr;
            }
            pre_curr = curr;
            curr = next;
        }
        return curr;
    }  
}
