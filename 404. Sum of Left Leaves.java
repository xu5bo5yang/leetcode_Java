/**
 * https://leetcode.com/problems/sum-of-left-leaves/submissions/
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        TreeNode leftNode = root.left;
        
        int leftVal = 0;
        
        if (leftNode != null && leftNode.left == null && leftNode.right == null) {
            leftVal = leftNode.val;
        } else {
            leftVal = sumOfLeftLeaves(leftNode);
        }
        
        return leftVal + sumOfLeftLeaves(root.right);
    }
}