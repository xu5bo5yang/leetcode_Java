/**
 * https://leetcode.com/problems/binary-search-tree-iterator/submissions/
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
class BSTIterator {

    List<Integer> valList;
    int index;
    
    public BSTIterator(TreeNode root) {
        valList = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        
        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            valList.add(cur.val);
            cur = cur.right;
        }
        
        index = 0;
    }
    
    /** @return the next smallest number */
    public int next() {
        int val = valList.get(index);
        index++;
        
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < valList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */