/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }
        
        if (p == q) {
            return p;
        }
        
        if (q.val < p.val) {
            TreeNode tmp = q;
            q = p;
            p = tmp;
        }
        
        if (p.val < root.val && q.val > root.val) {
            return root;
        } else if (q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}