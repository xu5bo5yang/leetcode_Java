/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/submissions/
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        
        List<TreeNode> result = new ArrayList<TreeNode>();
        result.add(null);
        
        for (int i = 1; i <= n; i++) {
            List<TreeNode> newResult = new ArrayList<TreeNode>();
            
            for (TreeNode root : result) {
                TreeNode newRoot = new TreeNode(i);
                newRoot.left = root;
                newResult.add(newRoot);
                
                for (int j = 0; j < n; j++) {
                    TreeNode copyRoot = copyTree(root);
                    TreeNode cur = copyRoot;
                    
                    for (int k = 0; k < j; k++) {
                        cur = cur.right;
                    }
                    
                    if (cur == null) {
                        break;
                    } else {
                        TreeNode newNode = new TreeNode(i);
                        newNode.left = cur.right;
                        cur.right = newNode;
                        
                        newResult.add(copyRoot);
                    }
                }
            }
            
            result = newResult;
        }
        
        return result;
    }
    
    TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = root.left == null ? null : copyTree(root.left);
        newRoot.right = root.right == null ? null : copyTree(root.right);
        
        return newRoot;
    }
}