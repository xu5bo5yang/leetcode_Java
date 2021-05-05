/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList();
        Node cur = root;
        
        while(cur != null || !queue.isEmpty()) {
            if (queue.isEmpty()) {
                cur.next = null;
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                Queue<Node> newQueue = new LinkedList();
                cur = queue.poll();
                
                if (cur == null) {
                    break;
                }
                
                while (!queue.isEmpty()) {
                    Node nextCur = queue.poll();
                    cur.next = nextCur;
                    newQueue.add(cur.left);
                    newQueue.add(cur.right);
                    cur = nextCur;
                }
                
                newQueue.add(cur.left);
                newQueue.add(cur.right);
                cur.next = null;
                queue = newQueue;
            }
        }
        
        return root;
    }
}