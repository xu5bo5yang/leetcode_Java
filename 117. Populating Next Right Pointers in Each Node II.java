/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
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
        if (root == null) {
            return root;
        }
        
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            Queue<Node> newQueue = new LinkedList();
                
            while (!queue.isEmpty()) {
                Node nextCur = queue.poll();
                cur.next = nextCur;
                if (cur.left != null) {
                    newQueue.add(cur.left);
                }
                if (cur.right != null) {
                    newQueue.add(cur.right);
                }
                cur = nextCur;
            }
                
            if (cur.left != null) {
                newQueue.add(cur.left);
            }
            if (cur.right != null) {
                newQueue.add(cur.right);
            }
            cur.next = null;
            queue = newQueue;
        }
        
        return root;
    }
}