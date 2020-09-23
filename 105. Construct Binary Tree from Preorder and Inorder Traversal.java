/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeWithRoot(0, inorderMap, 0, inorder.length - 1, preorder, inorder);
    }
    
    TreeNode buildTreeWithRoot(int pre, Map<Integer, Integer> inorderMap, int inLeft, int inRight, int[] preorder, int[] inorder) {
        if (pre >= preorder.length || inLeft > inRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pre]);
        int rootIndex = inorderMap.get(preorder[pre]);
        
        root.left = buildTreeWithRoot(pre + 1, inorderMap, inLeft, rootIndex - 1, preorder, inorder);
        root.right = buildTreeWithRoot(pre+ rootIndex - inLeft + 1, inorderMap, rootIndex + 1, inRight, preorder, inorder);
        
        return root;
    }
}