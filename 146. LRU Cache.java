/**
 * https://leetcode.com/problems/lru-cache/submissions/
 */
class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Node head;
    Node tail;
    Map<Integer, Node> nodeMap;
    int capacity;
    
    public LRUCache(int capacity) {
        this.nodeMap = new HashMap();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node cur = nodeMap.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            
            insertNode(head, tail, cur);
            
            return cur.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node cur = nodeMap.get(key);
            cur.value = value;
            nodeMap.put(key, cur);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            
            insertNode(head, tail, cur);
        } else {
            if (nodeMap.size() >= capacity) {
                nodeMap.remove(tail.prev.key);
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
            }
            
            Node cur = new Node(key, value);
            nodeMap.put(key, cur);
            
            insertNode(head, tail, cur);
        }
    }
    
    void insertNode(Node head, Node tail, Node cur) {
        cur.next = head.next;
        cur.next.prev = cur;
        head.next = cur;
        cur.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */