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
        
        return buildTree(nums, 0, nums.length - 1);
    }
    
    TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        
        int index = l;
        
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, l, index - 1);
        root.right = buildTree(nums, index + 1, r);
        
        return root;
    }
}