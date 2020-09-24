/**
 * https://leetcode.com/problems/path-sum-ii/submissions/
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList();
        }
        
        List<List<Integer>> results = new ArrayList();
        List<Integer> prev = new ArrayList();
        
        recursiveFindSolution(results, prev, root, sum);
        
        return results;
    }
    
    void recursiveFindSolution(List<List<Integer>> results, List<Integer> prev, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        
        prev.add(root.val);
        
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> result = new ArrayList();
            result.addAll(prev);
            
            results.add(result);
        }
        
        recursiveFindSolution(results, prev, root.left, sum - root.val);
        recursiveFindSolution(results, prev, root.right, sum - root.val);
        
        prev.remove(prev.size() - 1);
    }
}