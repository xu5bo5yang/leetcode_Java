/**
 * https://leetcode.com/problems/delete-node-in-a-bst/submissions/
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = getMinimum(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        
        return root;
    }
    
    int getMinimum(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        
        return root.val;
    }
}