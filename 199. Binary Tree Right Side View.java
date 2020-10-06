/**
 * https://leetcode.com/problems/binary-tree-right-side-view/submissions/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        
        rightSideView(root, result, 0);
        
        return result;
    }
    
    void rightSideView(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        
        if (result.size() == depth) {
            result.add(root.val);
        }
        
        rightSideView(root.right, result, depth + 1);
        rightSideView(root.left, result, depth + 1);
        
        return;
    }
}