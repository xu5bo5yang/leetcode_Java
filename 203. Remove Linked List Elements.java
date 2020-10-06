/**
 * https://leetcode.com/problems/remove-linked-list-elements/submissions/
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0, head);
        ListNode prev = result;
        ListNode cur = result.next;
        
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {          
                prev = prev.next;
                cur = prev.next;
            }
        }
        
        return result.next;
    }
}