/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
import java.util.*;
public class Solution {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { 
            label = x; 
            neighbors = new ArrayList<UndirectedGraphNode>(); 
        }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode copy_node = new UndirectedGraphNode(node.label);
        LinkedList<UndirectedGraphNode> queue =  new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        queue.offer(copy_node);
        visited.put(node, true);
        map.put(node, copy_node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr_origin = queue.poll();
            UndirectedGraphNode curr_copy = queue.poll();
            if(curr_origin.neighbors.size() > 0) {
                for(UndirectedGraphNode curr_origin_sub : curr_origin.neighbors) {
                    if(!visited.containsKey(curr_origin_sub)) {
                        UndirectedGraphNode curr_copy_sub = new UndirectedGraphNode(curr_origin_sub.label);
                        curr_copy.neighbors.add(curr_copy_sub);
                        queue.offer(curr_origin_sub);
                        queue.offer(curr_copy_sub);
                        visited.put(curr_origin_sub, true);
                        map.put(curr_origin_sub, curr_copy_sub);
                    }
                    else {
                        UndirectedGraphNode curr_copy_sub  = map.get(curr_origin_sub);
                        curr_copy.neighbors.add(curr_copy_sub);
                    }
                }
            }
        }
        return copy_node;
    }
}
