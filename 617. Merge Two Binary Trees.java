/**
 * https://leetcode.com/problems/merge-two-binary-trees/submissions/
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newTree = new TreeNode();
        
        if (t1 == null && t2 == null) {
            return null;
        }
        
        if (t1 == null) {
            newTree = t2;
        } else if (t2 == null) {
            newTree = t1;
        } else {
            newTree.val = t1.val + t2.val;
            newTree.left = mergeTrees(t1.left, t2.left);
            newTree.right = mergeTrees(t1.right, t2.right);
        }
        
        return newTree;
    }
}