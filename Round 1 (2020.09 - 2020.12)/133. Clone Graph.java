/**
 * https://leetcode.com/problems/clone-graph/submissions/
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visitedMap = new HashMap();
        
        return cloneNode(node, visitedMap);
    }
    
    Node cloneNode(Node node, Map<Node, Node> visitedMap) {
        if (node == null) {
            return null;
        }
        
        if (visitedMap.containsKey(node)) {
            return visitedMap.get(node);
        }
        
        Node newNode = new Node(node.val);
        visitedMap.put(node, newNode);
        
        for (Node neighbor : node.neighbors) {
            if (visitedMap.containsKey(neighbor)) {
                newNode.neighbors.add(visitedMap.get(neighbor));
            } else {
                newNode.neighbors.add(cloneNode(neighbor, visitedMap));
            }
        }
        
        return newNode;
    }
}