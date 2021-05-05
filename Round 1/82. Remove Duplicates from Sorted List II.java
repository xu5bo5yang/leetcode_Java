/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode result = new ListNode(0, head);
        ListNode prev = result;
        ListNode cur = head;
        
        while (cur != null) {
            while (cur.next != null && cur.next.val == prev.next.val) {
                cur = cur.next;
            }
            
            if (cur == prev.next) {
                cur = cur.next;
                prev = prev.next;
            } else {
                prev.next = cur.next;
                cur = cur.next;
            }
        }
        
        return result.next;
    }
}