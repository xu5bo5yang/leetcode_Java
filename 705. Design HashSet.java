/**
 * https://leetcode.com/problems/design-hashset/submissions/
 */
class MyHashSet {
    
    class Node {
        int val;
        Node left;
        Node right;
        
        public Node(int val) {
            this.val = val;
        }
    }
  
    Node insertRec(Node root, int key) { 
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
  
        if (root.val < key) {
            root.right = insertRec(root.right, key); 
        } else if (root.val > key) {
            root.left = insertRec(root.left, key); 
        }
  
        return root; 
    }
    
    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
 
        if (root.val < key) {
            root.right = deleteRec(root.right, key);
        } else if (root.val > key) {
            root.left = deleteRec(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = minValue(root.right);
                root.right = deleteRec(root.right, root.val);
            }
        }
 
        return root;
    }
    
    int minValue(Node root) {
        int minv = root.val;
        
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        
        return minv;
    }
    
    boolean contains(Node root, int key) {
        if (root == null) {
            return false;
        } 
        
        if (root.val == key) {
            return true;
        }

        if (root.val < key) {
            return contains(root.right, key); 
        } else {
            return contains(root.left, key); 
        }
    }
    
    private Node root;

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        root = insertRec(root, key);
    }
    
    public void remove(int key) {
        root = deleteRec(root, key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return contains(root, key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */