/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/submissions/
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList();
        int left = 0;
        int right = 0;
        
        while (head != null) {
            nums.add(head.val);
            right++;
            head = head.next;
        }
        
        return buildTree(nums, left, right - 1);
    }
    
    TreeNode buildTree(List<Integer> nums, int left, int right) {
        if (nums == null || nums.size() == 0 || left > right) {
            return null;
        }
        
        if (left == right) {
            return new TreeNode(nums.get(left), null, null);
        }
        
        int mid = left + (right - left) / 2;
        
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        
        return root;
    }
}