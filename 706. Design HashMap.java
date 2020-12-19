/**
 * https://leetcode.com/problems/design-hashmap/submissions/
 */
class MyHashMap {

    class Node {
        int key;
        int val;
        Node left;
        Node right;
        
        public Node(int key) {
            this.key = key;
        }
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
  
    Node insertRec(Node root, int key, int val) { 
        if (root == null) { 
            root = new Node(key, val); 
            return root; 
        }
          
        if (root.key < key) {
            root.right = insertRec(root.right, key, val); 
        } else if (root.key > key) {
            root.left = insertRec(root.left, key, val); 
        } else {
            root.val = val;
        }
        
        return root;
    }
    
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
 
        if (root.key < key) {
            root.right = deleteRec(root.right, key);
        } else if (root.key > key) {
            root.left = deleteRec(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int[] rightMin = minValue(root.right);
                root.key = rightMin[0];
                root.val = rightMin[1];
                root.right = deleteRec(root.right, root.key);
            }
        }
 
        return root;
    }
    
    int[] minValue(Node root) {
        int[] min = new int[2];
        min[0] = root.key;
        min[1] = root.val;
        
        while (root.left != null) {
            min[0] = root.left.key;
            min[1] = root.left.val;
            root = root.left;
        }
        
        return min;
    }
    
    int search(Node root, int key) {
        if (root == null) {
            return -1;
        } 
        
        if (root.key == key) {
            return root.val;
        }

        if (root.key < key) {
            return search(root.right, key); 
        } else {
            return search(root.left, key); 
        }
    }
    
    private Node root;

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        root = insertRec(root, key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return search(root, key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        root = deleteRec(root, key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */