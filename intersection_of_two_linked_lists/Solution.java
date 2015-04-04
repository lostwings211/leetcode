public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        int countA = 0; 
        int countB = 0;
        
        while(currA != null || currB != null) {
            if(currA !=  null) {
                currA = currA.next;
                countA++;
            }
            if(currB != null) {
                currB = currB.next;
                countB++;
            }
        }
        
        currA = headA;
        currB = headB;
        if(countA > countB) {
            for(int i = 0; i < countA - countB; i++) {
                currA = currA.next;
            }
        }
        else {
            for(int i = 0; i < countB - countA; i++) {
                currB = currB.next;
            }
        }
        
        while(currA != null) {
            if(currA == currB) {
                return currA;
            }
            currA =  currA.next;
            currB =  currB.next;
        }
        return currA;
    }
}
