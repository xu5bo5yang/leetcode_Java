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
    
    private int result;
    private int count;
    
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        
        traverse(root, k);
        
        return result;
    }
    
    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, k);
        count++;
        
        if (count == k) {
            result = root.val;
            return;
        }
        
        traverse(root.right, k);
    }
}