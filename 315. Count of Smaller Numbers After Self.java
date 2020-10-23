/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/
 */
class Solution {
    class Node{
        int val;
        int leftCount;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        Node root = null;
        List<Integer> result = new ArrayList<>();
        
        for(int i = nums.length-1; i >= 0; i--){
            root = insertIntoBST(result, root, nums[i], 0);
        }
        
        Collections.reverse(result);
        return result;
    }
    
    Node insertIntoBST(List<Integer> result, Node root, int val, int sum){
        if(root == null){
            result.add(sum);
            
            return new Node(val);
        }
        
        if (root.val < val){
            sum += root.leftCount + 1;
            root.right = insertIntoBST(result, root.right, val, sum);
        } else {
            root.left = insertIntoBST(result, root.left, val, sum);
            root.leftCount += 1;
        }
        
        return root;
    }
}