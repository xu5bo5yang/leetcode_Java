/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    
    TreeNode buildTree(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0 || left > right) {
            return null;
        }
        
        if (left == right) {
            return new TreeNode(nums[left], null, null);
        }
        
        int mid = left + (right - left) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        
        return root;
    }
}