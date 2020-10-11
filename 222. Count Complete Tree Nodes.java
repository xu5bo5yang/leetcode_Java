/**
 * https://leetcode.com/problems/count-complete-tree-nodes/submissions/
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        boolean notBottom = true;
        int count = 0;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(notBottom) {
            count += level;
            level *= 2;

            Queue<TreeNode> newQueue = new LinkedList();
            while(queue.size() > 0) {
                TreeNode node = queue.poll();
                
                if (node.left == null || node.right == null) {
                    notBottom = false;
                    
                    count += newQueue.size() + 1;
                    if (node.left == null && node.right == null) {
                        count--;
                    }
                    
                    break;
                }

                newQueue.add(node.left);
                newQueue.add(node.right);
            }
            
            queue = newQueue;
        }
        
        return count;
    }
}