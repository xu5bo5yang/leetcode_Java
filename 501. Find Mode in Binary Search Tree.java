/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/submissions/
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
    int maxCount = 0;
    
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0]; 
        }
        
        Map<Integer, Integer> valCount = new HashMap(); 
        
        traverse(root, valCount); 
        
        List<Integer> modeList = new ArrayList();
        
        for (int key: valCount.keySet()){
            if (valCount.get(key) == maxCount) {
                modeList.add(key);
            }
        }
        
        int[] result = new int[modeList.size()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = modeList.get(i);
        }
        
        return result;
    }
    
    void traverse(TreeNode node, Map<Integer, Integer> valCount){
        if (node.left != null) {
            traverse(node.left, valCount);
        }
        
        valCount.put(node.val, valCount.getOrDefault(node.val, 0) + 1);
        maxCount = Math.max(maxCount, valCount.get(node.val));
        
        if (node.right != null) {
            traverse(node.right, valCount);
        }
    }
}