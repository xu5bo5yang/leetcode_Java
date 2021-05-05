/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap();
        
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeWithRoot(postorder.length - 1, 0, inorder.length - 1, inorderMap, inorder, postorder);
    }
    
    TreeNode buildTreeWithRoot(int postPos, int inLeft, int inRight, Map<Integer, Integer> inorderMap, int[] inorder, int[] postorder) {
        if (postPos < 0 || inLeft > inRight) {
            return null;
        }
        
        int rootVal = postorder[postPos];
        int inPos = inorderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.right = buildTreeWithRoot(postPos - 1, inPos + 1, inRight, inorderMap, inorder, postorder);
        root.left = buildTreeWithRoot(postPos - inRight + inPos - 1, inLeft, inPos - 1, inorderMap, inorder, postorder);
        
        return root;
    }
}