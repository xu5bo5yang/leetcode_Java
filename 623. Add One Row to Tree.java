/**
 * https://leetcode.com/problems/add-one-row-to-tree/submissions/
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            
            return newNode;
        }
        
        insertNode(root, v, d, 1);
        
        return root;
    }
    
    void insertNode(TreeNode node, int v, int d, int curDepth) {
        if (node == null) {
            return;
        }
        
        if (curDepth == d - 1) {
            TreeNode nLeft = node.left;
            node.left = new TreeNode(v);
            node.left.left = nLeft;
            
            TreeNode nRight = node.right;
            node.right = new TreeNode(v);
            node.right.right = nRight;
        } else {
            insertNode(node.left, v, d, curDepth + 1);
            insertNode(node.right, v, d, curDepth + 1);
        }
    }
}