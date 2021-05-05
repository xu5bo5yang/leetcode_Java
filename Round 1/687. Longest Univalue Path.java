/**
 * https://leetcode.com/problems/longest-univalue-path/submissions/
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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int max = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        
        return Math.max(max, childPath(root.left, root.val) + childPath(root.right, root.val));
    }
    
    private int childPath(TreeNode node, int val) {
        if (node == null || node.val != val) {
            return 0;
        }
        
        return 1 + Math.max(childPath(node.left, val), childPath(node.right, val));
    }
}