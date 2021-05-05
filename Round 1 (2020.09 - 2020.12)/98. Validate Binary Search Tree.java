/**
 * https://leetcode.com/problems/validate-binary-search-tree/submissions/
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
    public boolean isValidBST(TreeNode root) {
        Integer lastVal = null;
        Stack<TreeNode> stack = new Stack();
        
        while(root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if (lastVal != null && root.val <= lastVal) {
                return false;
            }
            
            lastVal = root.val;
            root = root.right;
        }
        
        return true;
    }
}