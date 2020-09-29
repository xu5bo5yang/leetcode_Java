/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/submissions/
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Map<Node, Node> nodeMap = new HashMap();
        
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            nodeMap.put(cur, newNode);
            
            cur = cur.next;
        }
        
        cur = head;
        while (cur != null) {
            Node newNode = nodeMap.get(cur);
            newNode.next = nodeMap.get(cur.next);
            newNode.random = nodeMap.get(cur.random);
            
            cur = cur.next;
        }
        
        return nodeMap.get(head);
    }
}