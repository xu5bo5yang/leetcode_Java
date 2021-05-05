/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack();
        stack.push(root); 
        TreeNode prev = null; 
        
        while (!stack.isEmpty()) { 
            TreeNode cur = stack.peek(); 

            if (prev == null || prev.left == cur || prev.right == cur) { 
                if (cur.left != null) {
                    stack.push(cur.left); 
                } else if (cur.right != null) {
                    stack.push(cur.right); 
                } else { 
                    stack.pop(); 
                    result.add(cur.val); 
                } 
            } else if (cur.left == prev) { 
                if (cur.right != null) {
                    stack.push(cur.right); 
                }
                else { 
                    stack.pop(); 
                    result.add(cur.val);                 
                } 
            } else if (cur.right == prev) { 
                stack.pop(); 
                result.add(cur.val); 
            } 
   
            prev = cur; 
        } 
        
        return result;
    }
}