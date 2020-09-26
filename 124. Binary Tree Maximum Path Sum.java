/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
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
    private int result;
    
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        maxSum(root);
        
        return result;
    }
    
    int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftMax = maxSum(root.left);
        int rightMax = maxSum(root.right);
        int childMax = Math.max(leftMax, rightMax);
        int rootMax = Math.max(root.val, root.val + childMax);
        int fullMax = Math.max(rootMax, leftMax + rightMax + root.val);
        
        result = Math.max(result, fullMax);
        
        return rootMax;
    }
}