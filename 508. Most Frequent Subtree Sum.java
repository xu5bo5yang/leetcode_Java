/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/submissions/
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
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        
        Map<Integer, Integer> sumCounts = new HashMap();
        List<Integer> list = new ArrayList();
        int max = 0;
                
        sumTree(root, sumCounts);

        for (Map.Entry<Integer, Integer> entry : sumCounts.entrySet()) {
            int count = entry.getValue();
            
            if (max < count) {
                list.clear();
                max = count;
            }
            
            if (max == count) {
                list.add(entry.getKey());
            }
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    int sumTree(TreeNode root, Map<Integer, Integer> sumCounts) {
        if (root == null) {
            return 0;
        }
        
        int left = sumTree(root.left, sumCounts);
        int right = sumTree(root.right, sumCounts);
        int sum = left + right + root.val;
        
        sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
        
        return sum;
    }
}