/**
 * https://leetcode.com/problems/recover-binary-search-tree/submissions/
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
    public void recoverTree(TreeNode root) {
        Integer lastVal = null;
        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack();
        List<TreeNode> traverse = new ArrayList();
        
        while(root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            traverse.add(root);
            root = root.right;
        }
        
        int leftIndex = 0;
        while (leftIndex < traverse.size() - 1 && (traverse.get(leftIndex).val < traverse.get(leftIndex+1).val)) {
            leftIndex++;
        }
        
        int rightIndex = leftIndex;
        int leftVal = traverse.get(leftIndex).val;
        while (rightIndex < traverse.size() - 1 && (traverse.get(rightIndex+1).val < leftVal)) {
            rightIndex++;
        }
        
        traverse.get(leftIndex).val = traverse.get(rightIndex).val;
        traverse.get(rightIndex).val = leftVal;
    }
}