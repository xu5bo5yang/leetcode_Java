/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/submissions/
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root == null) {
            return result;
        }
        
        queue.add(root);
        
        while(true) {
            List<Integer> newList = new ArrayList<Integer>();
            Queue<TreeNode> newQueue = new LinkedList<TreeNode>();
            
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                newList.add(cur.val);
                
                if (cur.left != null) {
                    newQueue.add(cur.left);
                }
                
                if (cur.right != null) {
                    newQueue.add(cur.right);
                }
            }
            
            result.add(0, newList);
            
            if (newQueue.isEmpty()) {
                break;
            }
            queue = newQueue;
        }
        
        return result;
    }
}