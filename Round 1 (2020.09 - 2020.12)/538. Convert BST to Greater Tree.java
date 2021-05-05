/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/submissions/
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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            
            cur = stack.pop();
            
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        
        return root;
    }
}