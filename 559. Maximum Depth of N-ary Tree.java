/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/submissions/
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        if (root.children == null || root.children.size() < 1) {
            return 1;
        }
        
        int result = 0;
        
        for (Node child : root.children) {
            result = Math.max(result, maxDepth(child));
        }
        
        return result + 1;
    }
}