/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/submissions/
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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        sumNums(root, 0);
        
        return sum;
    }
    
    void sumNums(TreeNode root, int prev) {
        if (root == null) {
            return;
        }
        
        int curSum = prev * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            sum += curSum;
        } else {
            sumNums(root.left, curSum);
            sumNums(root.right, curSum);
        }
    }
}