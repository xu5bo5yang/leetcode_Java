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
        if (preorder == null || preorder.length < 1 ||
            inorder == null || inorder.length < 1) {
            return null;
        }
        
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int preLeft, int preRight, 
                           int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        
        int rootIndex = -1;
        
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                rootIndex = i;
                break;
            }
        }
        
        int sizeLeft = rootIndex - inLeft;
        
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = build(preorder, preLeft + 1, preLeft + sizeLeft, 
                          inorder, inLeft, rootIndex - 1);
        root.right = build(preorder, preLeft + sizeLeft + 1, preRight, 
                           inorder, rootIndex + 1, inRight);
        
        return root;
    }
}