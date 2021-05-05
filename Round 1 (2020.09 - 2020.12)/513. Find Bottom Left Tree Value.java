/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/submissions/
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
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    
    int findBottomLeftValue(TreeNode root, int height, int[] result) {
        if (result[1] < height) {
            result[0] = root.val;
            result[1] = height;
        }
        
        if (root.left!=null) {
            findBottomLeftValue(root.left, height + 1, result);
        }
        
        if (root.right!=null) {
            findBottomLeftValue(root.right, height + 1, result);
        }
        
        return result[0];
    }
}