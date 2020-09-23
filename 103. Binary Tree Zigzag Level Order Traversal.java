/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        boolean goLeft = true;
        
        if (root == null) {
            return result;
        }
        
        stack.add(root);
        
        while(true) {
            List<Integer> newList = new ArrayList<Integer>();
            Stack<TreeNode> newStack = new Stack<TreeNode>();
            
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                newList.add(cur.val);
                
                if (goLeft) {
                    if (cur.left != null) {
                        newStack.add(cur.left);
                    }
                    if (cur.right != null) {
                        newStack.add(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        newStack.add(cur.right);
                    }
                    if (cur.left != null) {
                        newStack.add(cur.left);
                    }
                }
            }
            
            goLeft = !goLeft;
            result.add(newList);
            
            if (newStack.isEmpty()) {
                break;
            }
            stack = newStack;
        }
        
        return result;
    }
}