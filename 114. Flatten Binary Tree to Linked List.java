/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        flattenReturnLastNode(root);
    }
    
    TreeNode flattenReturnLastNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            return flattenReturnLastNode(root.right);
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return flattenReturnLastNode(root.right);
        } else {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode leftAfterFlatten = flattenReturnLastNode(root.right);
            leftAfterFlatten.right = tmp;
            return flattenReturnLastNode(tmp);
        }
    }
}