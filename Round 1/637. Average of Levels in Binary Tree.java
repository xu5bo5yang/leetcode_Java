/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/
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
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        
        List<Double> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Queue<TreeNode> newQueue = new LinkedList();
            long sum = 0;
            int count = 0;
            
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                count++;
                
                if (cur.left != null) {
                    newQueue.add(cur.left);
                }
                
                if (cur.right != null) {
                    newQueue.add(cur.right);
                }
            }
            
            result.add(sum * 1.0 / count);
            queue = newQueue;
        }
        
        return result;
    }
}