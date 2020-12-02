/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
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
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();
        Stack<Node> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(cur.val);

            if (cur.children != null && cur.children.size() > 0) {
                for (int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        
        return result;
    }
}