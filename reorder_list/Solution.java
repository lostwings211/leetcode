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

    public void reorderList(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        ListNode curr = head;
        while(curr !=  null) {
            nodes.add(curr);
            curr = curr.next;
        }
        int length =  nodes.size();
        int half = length / 2;
        for(int i = 0; i < length; i++) {
            if(i == half) {
                nodes.get(i).next =  null;
            }
            else if(i < half) {
                nodes.get(i).next = nodes.get(length - i - 1);
            }
            else if( i > half) {
                nodes.get(i).next =  nodes.get(length - i);
            }
        }
    }
}
