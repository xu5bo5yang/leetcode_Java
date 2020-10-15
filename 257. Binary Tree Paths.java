/**
 * https://leetcode.com/problems/binary-tree-paths/submissions/
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        
        if (root == null) {
            return new ArrayList();
        }
        
        searchPath(result, "", root);
        
        return result.stream().collect(Collectors.toList());
    }
    
    void searchPath(List<String> result, String prev, TreeNode root) {        
        if (root.left == null && root.right == null) {
            result.add(prev + String.valueOf(root.val));
            return;
        } 
        
        String newPrev = prev + String.valueOf(root.val) + "->";
        
        if (root.left != null) {
            searchPath(result, newPrev, root.left);
        } 
        
        if (root.right != null) {
            searchPath(result, newPrev, root.right);
        }
    }
}