/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode head = new ListNode();
        ListNode current = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }
        }
        
        if (l1 != null) {
            current.next = new ListNode(l1.val, l1.next);
        } else if (l2 != null) {
            current.next = new ListNode(l2.val, l2.next);
        }
        
        return head.next;
    }
}