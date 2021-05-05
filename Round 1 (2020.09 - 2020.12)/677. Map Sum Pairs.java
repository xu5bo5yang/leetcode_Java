/**
 * https://leetcode.com/problems/map-sum-pairs/submissions/
 */
class MapSum {

    class TrieNode {
        int val;
        boolean isKey;
        Map<Character, TrieNode> children;
        
        public TrieNode() {
            isKey = false;
            children = new HashMap();
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        
        for (char c : key.toCharArray()) {
            TrieNode child = cur.children.get(c);
            
            if (child == null) {
                child = new TrieNode();
                cur.children.put(c, child);
            }
            
            cur = child;
        }
        
        cur.isKey = true;
        cur.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        
        for (char c : prefix.toCharArray()) {
            TrieNode child = cur.children.get(c);
            
            if (child == null) {
                return 0;
            }
            
            cur = child;
        }
        
        return getChildrenSum(cur);
    }
    
    int getChildrenSum(TrieNode root) {
        int sum = 0;
        
        for (char c : root.children.keySet()) {
            sum += getChildrenSum(root.children.get(c));
        }
        
        return root.val + sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */