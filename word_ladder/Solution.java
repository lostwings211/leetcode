import java.util.*;
public class Solution {
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();  
        dict.add(start);  
        dict.add(end);  
          
        // init adjacent graph          
        for(String str : dict){  
            calcNeighbours(neighbours, str, dict);  
        }  
          
        // BFS search queue  
        LinkedList<Node> queue = new LinkedList<Node>();  
        queue.add(new Node(null, start, 1)); //the root has not parent and its level == 1 
          
        // BFS level  
        int previousLevel = 0;  
          
        // mark which nodes have been visited, to break infinite loop  
        HashMap<String, Integer> visited = new HashMap<String, Integer>();   
        while(!queue.isEmpty()){  
            Node n = queue.pollFirst();              
            if(end.equals(n.str)){   
                return n.level;
            }else {  
                HashSet<String> set = neighbours.get(n.str);                   
                if(set == null || set.isEmpty()) continue;  
                ArrayList<String> toRemove = new ArrayList<String>();  
                for (String s : set) {  
                    if(visited.containsKey(s)){  
                        Integer occurLevel = visited.get(s);  
                        if(n.level+1 > occurLevel){  
                            toRemove.add(s);  
                            continue;  
                        }  
                    }  
                    visited.put(s,  n.level+1);  
                    queue.add(new Node(n, s, n.level + 1));  
                    neighbours.get(s).remove(n.str);  
                }  
                for(String s: toRemove){  
                    set.remove(s);  
                }  
            }  
        }  
        return 0;  
    }  
   
    /* 
     * complexity: O(26*str.length*dict.size)=O(L*N) 
     */  
    public static void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {  
        int length = str.length();  
        char [] chars = str.toCharArray();  
        for (int i = 0; i < length; i++) {  
              
            char old = chars[i];   
            for (char c = 'a'; c <= 'z'; c++) {  
  
                if (c == old)  continue;  
                chars[i] = c;  
                String newstr = new String(chars);                  
                  
                if (dict.contains(newstr)) {  
                    HashSet<String> set = neighbours.get(str);  
                    if (set != null) {  
                        set.add(newstr);  
                    } else {  
                        HashSet<String> newset = new HashSet<String>();  
                        newset.add(newstr);  
                        neighbours.put(str, newset);  
                    }  
                }                  
            }  
            chars[i] = old;  
        }  
    }  
      
    private static class Node {  
        public Node parent;  //previous node
        public String str;  
        public int level;  
        public Node(Node p, String s, int l){  
            parent = p;  
            str = s;  
            level = l;  
        }  
    }
}
