/**
 * https://leetcode.com/problems/path-sum-iii/submissions/
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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        return (root.val == sum ? 1 : 0) + findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
    }
}