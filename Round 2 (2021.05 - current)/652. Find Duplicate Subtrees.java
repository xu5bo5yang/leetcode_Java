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
    
    private HashMap<String, Integer> trees;
    private List<TreeNode> duplicateNodes;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        trees = new HashMap();
        duplicateNodes = new ArrayList();
        
        traverse(root);
        
        return duplicateNodes;
    }
    
    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        
        String tree = String.join(",", traverse(root.left), traverse(root.right), String.valueOf(root.val));
        
        int count = trees.getOrDefault(tree, 0);
        
        if (count == 1) {
            duplicateNodes.add(root);
        }
        
        trees.put(tree, count + 1);
        
        return tree;
    }
}