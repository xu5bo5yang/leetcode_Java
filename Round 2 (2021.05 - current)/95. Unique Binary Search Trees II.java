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
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList();
        }
        
        return buildTrees(1, n);
    }
    
    List<TreeNode> buildTrees(int l, int r) {
        List<TreeNode> result = new LinkedList();
        
        if (l > r) {
            result.add(null);
            
            return result;
        }
        
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTrees = buildTrees(l, i - 1);
            List<TreeNode> rightTrees = buildTrees(i + 1, r);
            
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    
                    result.add(cur);
                }
            }
        }
        
        return result;
    }
}