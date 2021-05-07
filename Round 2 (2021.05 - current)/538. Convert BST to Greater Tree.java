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
    
    private int sum;
    
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        traverse(root);
        
        return root;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}