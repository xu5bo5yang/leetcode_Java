/**
 * https://leetcode.com/problems/binary-tree-tilt/submissions/
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
    int totalTilt = 0;
    
    public int findTilt(TreeNode root) {
        nodeSum(root);
        
        return totalTilt;
    }
    
    int nodeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = nodeSum(root.left);
        int rightSum = nodeSum(root.right);
        
        totalTilt += Math.abs(leftSum - rightSum);
        
        return leftSum + rightSum + root.val;
    }
}