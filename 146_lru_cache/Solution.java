public class LRUCache {
    public class DoubleLinkedList {
        int val;
        int key;
        DoubleLinkedList prev;
        DoubleLinkedList next;
        
        DoubleLinkedList(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
    
    int capacity;
    int length;
    DoubleLinkedList start;
    DoubleLinkedList end;
    HashMap<Integer, DoubleLinkedList> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        start = null;
        end = null;
        map = new HashMap<Integer, DoubleLinkedList>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            DoubleLinkedList curr_node = map.get(key);
            RemoveNode(curr_node);
            AddToHead(curr_node);
            return curr_node.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DoubleLinkedList curr_node = map.get(key);
            curr_node.val = value;
            RemoveNode(curr_node);
            AddToHead(curr_node);
        }
        else {
            DoubleLinkedList new_node = new DoubleLinkedList(key, value);
            if(length < capacity) {
                AddToHead(new_node);
                length++;
            }
            else {
                if(end != null) {
                    map.remove(end.key);
                }
                //RemoveTail();
                end = end.prev;
                if (end != null) {
                    end.next = null;
                }
                
                AddToHead(new_node);
            }
            map.put(key, new_node);
        }
    }
    
    private void RemoveNode(DoubleLinkedList curr_node) {
        DoubleLinkedList pre_node = curr_node.prev;
        DoubleLinkedList post_node = curr_node.next;
        if(pre_node != null) {
            pre_node.next = post_node;
        }
        else {
            start = post_node;
        }
        
        if(post_node != null) {
            post_node.prev = pre_node;
        }
        else {
            end = pre_node;
        }
    }
    
    private void AddToHead(DoubleLinkedList node) {
        node.next = start;
        node.prev = null;
        if (start != null) {
            start.prev = node;
        }
 
        start = node;
        if (end == null) {
            end = node;
        }
    }
    
    private void RemoveTail() {
        if(end != null) {
            DoubleLinkedList prev_node = end.prev;
            if(prev_node != null) {
                prev_node.next = null;
            }
            else {
                start = null;
            }
            end = prev_node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
