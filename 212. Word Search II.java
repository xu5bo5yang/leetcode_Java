/**
 * https://leetcode.com/problems/word-search-ii/submissions/
 */
class Solution {
    class Node {
        String val;
        Map<Character, Node> next;
        
        public Node() {
            next = new HashMap();
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = buildTrie(words);
        Set<String> result = new HashSet();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(result, root, board, i, j);
            }
        }
        
        return result.stream().collect(Collectors.toList());
    }
    
    void search(Set<String> result, Node root, char[][] board, int i, int j) {
        char c = board[i][j];
        
        if (c == '*' || root.next.get(c) == null) {
            return;
        }
        
        root = root.next.get(c);
        
        if (root.val != null) {
            result.add(root.val);
        }

        board[i][j] = '*';
    
        if (i > 0) {
            search(result, root, board, i-1, j);
        }
    
        if (j > 0) {
            search(result, root, board, i, j-1);
        }
    
        if (i < board.length - 1) {
            search(result, root, board, i+1, j); 
        }
    
        if (j < board[0].length - 1) {
            search(result, root, board, i, j+1); 
        }
    
        board[i][j] = c;
        return;
    }
    
    Node buildTrie(String[] words) {
        Node root = new Node();
        
        for (String word : words) {
            Node cur = root;
            
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                
                if (cur.next.containsKey(c)) {
                    cur = cur.next.get(c);
                } else {
                    Node newNode = new Node();
                    cur.next.put(c, newNode);
                    cur = newNode;
                }
            }
            
            cur.val = word;
        }
        
        return root;
    }
}