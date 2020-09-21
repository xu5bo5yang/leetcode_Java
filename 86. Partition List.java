/**
 * https://leetcode.com/problems/partition-list/submissions/
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
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode left = leftHead;
        ListNode right = rightHead;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            
            head = head.next;
        }
        
        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
    }
}