/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/submissions/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Queue<TreeNode> nextRow = new LinkedList();
            
            int max = Integer.MIN_VALUE;
            
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    nextRow.add(node.left);
                }
                
                if (node.right != null) {
                    nextRow.add(node.right);
                }
                
                max = Math.max(max, node.val);
            }
            
            result.add(max);
            queue = nextRow;
        }
        
        return result;
    }
}