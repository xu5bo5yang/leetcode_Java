/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/submissions/
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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        int leftMin = findMin(root.left, root.val);
        int rightMin = findMin(root.right, root.val);
        int min = Math.min(leftMin, rightMin);
        
        if (leftMin == -1) {
            min = rightMin;
        } else if (rightMin == -1) {
            min = leftMin;
        }
        
        if (min == root.val) {
            return -1;
        }
        
        return min;
    }
    
    int findMin(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }
        
        if (root.val != min) {
            return root.val;
        }
        
        int leftMin = findMin(root.left, min);
        int rightMin = findMin(root.right, min);
        
        if (leftMin == -1) {
            return rightMin;
        } else if (rightMin == -1) {
            return leftMin;
        } else {
            return Math.min(leftMin, rightMin);
        }
    }
}