/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/submissions/
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
    public boolean findTarget(TreeNode root, int k) {
        return find(root, root,  k);
    }
    
    boolean find(TreeNode root, TreeNode cur, int k){
        if (cur == null) {
            return false;
        }
        
        return binarySearch(root, cur, k - cur.val) || 
            find(root, cur.left, k) || 
            find(root, cur.right, k);
    }
    
    boolean binarySearch(TreeNode root, TreeNode cur, int value){
        if (root == null) {
            return false;
        }
        
        return root.val == value && root != cur || 
            (root.val < value && binarySearch(root.right, cur, value)) || 
            (root.val > value && binarySearch(root.left, cur, value));
    }
}