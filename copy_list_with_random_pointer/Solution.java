/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
import java.util.*;
public class Solution {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { 
            this.label = x; 
        }
    };
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return head;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr_prev = head;
        RandomListNode curr_prev_copy = new RandomListNode(curr_prev.label);
        map.put(curr_prev, curr_prev_copy);
        
        while(curr_prev.next !=  null) {
            RandomListNode curr =  curr_prev.next;
            RandomListNode curr_copy = new RandomListNode(curr.label);
            curr_prev_copy.next = curr_copy;
            map.put(curr, curr_copy);
            curr_prev = curr;
            curr_prev_copy = curr_copy;
        }
        curr_prev_copy.next = null;
        
        RandomListNode curr_node = head;
        while(curr_node != null) {
            RandomListNode curr_node_copy = map.get(curr_node);
            if(curr_node.random == null) {
                curr_node_copy.random = null;
            }
            else {
                curr_node_copy.random = map.get(curr_node.random);
            }
            curr_node = curr_node.next;
        }
        
        return map.get(head);
        
    }
}
