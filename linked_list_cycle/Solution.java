import java.util.*;
public class Solution {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast.next != null) {
            if(slow == fast) {
                return true;
            }
            if(fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    
    public boolean hasCycle_withStorage(ListNode head) {
        HashMap<ListNode, Boolean> visited = new HashMap<ListNode, Boolean>();
        ListNode curr = head;
        while(curr != null) {
            if(visited.containsKey(curr)) {
                return true;
            }
            visited.put(curr, true);
            curr = curr.next;
        }
        return false;
    }
}
