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
        if (inorder == null || inorder.length < 1 ||
            postorder == null || postorder.length < 1) {
            return null;
        }
        
        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int inLeft, int inRight,
                           int[] postorder, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }
        
        int rootIndex = -1;
        
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == postorder[postRight]) {
                rootIndex = i;
                break;
            }
        }
        
        int sizeLeft = rootIndex - inLeft;
        
        TreeNode root = new TreeNode(postorder[postRight]);
        root.left = build(inorder, inLeft, rootIndex - 1,
                          postorder, postLeft, postLeft + sizeLeft - 1);
        root.right = build(inorder, rootIndex + 1, inRight,
                           postorder, postLeft + sizeLeft, postRight - 1);
        
        return root;
    }
}