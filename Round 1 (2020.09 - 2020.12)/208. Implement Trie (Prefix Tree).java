/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
 */
class Trie {
    class Node {
        char c;
        boolean hasWord;
        Map<Character, Node> children;
        
        public Node(char c) {
            this.c = c;
            children = new HashMap();
        }
    }
    
    Node head;

    /** Initialize your data structure here. */
    public Trie() {
        head = new Node('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = head;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                Node newNode = new Node(c);
                cur.children.put(c, newNode);
                cur = newNode;
            }
        }
        
        cur.hasWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = head;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                return false;
            }
        }
        
        return cur.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = head;
        
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else {
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */