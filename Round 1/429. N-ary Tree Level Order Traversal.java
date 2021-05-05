/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
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
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                curLevel.add(cur.val);
                for (Node child : cur.children)
                    queue.offer(child);
            }
            
            result.add(curLevel);
        }
        
        return result;
    }
}