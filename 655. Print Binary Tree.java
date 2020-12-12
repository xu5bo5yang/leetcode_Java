/**
 * https://leetcode.com/problems/print-binary-tree/submissions/
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
    public List<List<String>> printTree(TreeNode root) {
        int row = getHeight(root);
        int col = (int) Math.pow(2, row) - 1;
        List<List<String>> result = new ArrayList();

        for(int i = 0 ; i < row; i++) {
            result.add(new ArrayList());
            
            for(int j = 0; j < col; j++) {
                result.get(i).add("");
            }
        }
        
        printTree(result, root, 0, 0, col - 1);
        
        return result;
    }
    
    void printTree(List<List<String>> result, TreeNode root, int row, int left, int right) {
        if(root == null) {
            return;
        }
        
        int col = (left + right) / 2;
        result.get(row).set(col, root.val + "");
        
        printTree(result, root.left, row + 1, left, col - 1);
        printTree(result, root.right, row + 1, col + 1, right);
    }
    
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}