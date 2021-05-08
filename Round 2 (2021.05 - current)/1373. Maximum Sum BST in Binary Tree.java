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
    
    private class Node {
        boolean isBST;
        int min;
        int max;
        int sum;
        
        public Node(boolean isBST) {
            this.isBST = isBST;
        }
        
        public Node(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
        
        public boolean isBST() {
            return this.isBST;
        }
        
        public int getMin() {
            return this.min;
        }
        
        public int getMax() {
            return this.max;
        }
        
        public int getSum() {
            return this.sum;
        }
    }
    
    private int maxSum;
    
    public int maxSumBST(TreeNode root) {
        traverse(root);
        
        return maxSum;
    }
    
    Node traverse(TreeNode root) {
        if (root == null) {
            return new Node(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        Node leftChild = traverse(root.left);
        Node rightChild = traverse(root.right);
        
        if (leftChild.isBST() && rightChild.isBST() && 
            leftChild.getMax() < root.val && 
            rightChild.getMin() > root.val) {
            int rootSum = leftChild.getSum() + rightChild.getSum() + root.val;
            maxSum = Math.max(maxSum, rootSum);
            
            return new Node(true, 
                            Math.min(leftChild.getMin(), root.val),
                            Math.max(rightChild.getMax(), root.val),
                            rootSum);
        } else {
            return new Node(false);
        }
    }
}