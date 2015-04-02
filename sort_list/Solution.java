public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        int count = nodeCount(head);
        if(count <= 1) {
            return head;
        }
        ListNode pre_curr = new ListNode(0);
        pre_curr.next = head;
        for(int i = 0; i < count / 2; i++) {
            pre_curr = pre_curr.next;
        }
        
        ListNode temp = pre_curr.next;
        pre_curr.next = null;
        
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(temp);
        return combine(node1, node2);
    }
    
    public int nodeCount(ListNode head) {
        int count = 0;
        if(head != null) {
            while(head !=  null) {
                head = head.next;
                count++;
            }
        }
        return count;
    }
    
    public ListNode combine(ListNode node1, ListNode node2) {
        if(node1 == null) {
            return node2;
        }
        if(node2 == null) {
            return node1;
        }
        ListNode pre_head = new ListNode(0);
        ListNode curr_pre = pre_head;
        while((node1 != null) && (node2 !=  null)) {
            if(node1.val <= node2.val) {
                curr_pre.next = node1;
                node1 = node1.next;
            }
            else {
                curr_pre.next = node2;
                node2 = node2.next;
            }
            curr_pre = curr_pre.next;
        }
        
        if(node1 == null) {
            curr_pre.next = node2;
        }
        else {
            curr_pre.next = node1;      
        }
        return pre_head.next;
    }
}
