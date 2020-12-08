/**
 * https://leetcode.com/problems/find-duplicate-subtrees/submissions/
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new LinkedList<>();
        
        postorder(root, new HashMap(), result);
        
        return res;
    }
    
    String postorder(TreeNode node, Map<String, Integer> serialCount, List<TreeNode> result) {
        if (node == null) {
            return "#";  
        }
        
        String serial = node.val + "," + postorder(node.left, serialCount, result) + "," + postorder(node.right, serialCount, result);
        serialCount.put(serial, serialCount.getOrDefault(serial, 0) + 1);
        
        if (serialCount.get(serial) == 2) {
            result.add(node);
        }
        
        return serial;
    }
}