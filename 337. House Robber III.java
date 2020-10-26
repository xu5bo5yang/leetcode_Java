/**
 * https://leetcode.com/problems/house-robber-iii/submissions/
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
    public int rob(TreeNode root) {
        int[] result = robNode(root);
        
        return Math.max(result[0], result[1]);
    }
    
    int[] robNode(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        
        int left[] = robNode(node.left);
        int right[] = robNode(node.right);

        int rob = node.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}