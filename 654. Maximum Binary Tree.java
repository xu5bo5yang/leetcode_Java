/**
 * https://leetcode.com/problems/maximum-binary-tree/submissions/
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        
        return constructTree(nums, 0, nums.length - 1);
    }
    
    TreeNode constructTree(int[] nums, int left, int right) {
        int rootIndex = left;
        int max = Integer.MIN_VALUE;
        
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                rootIndex = i;
                max = nums[i];
            }
        }
        
        TreeNode root = new TreeNode(max);
        
        if (left != rootIndex) {
            root.left = constructTree(nums, left, rootIndex - 1);
        }
            
        if (right != rootIndex) {
            root.right = constructTree(nums, rootIndex + 1, right);
        }
        
        return root;
    }
}