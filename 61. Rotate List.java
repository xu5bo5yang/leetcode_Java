/**
 * https://leetcode.com/problems/rotate-list/submissions/
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
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 0 || head == null || head.next == null) {
            return head;
        }
        
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        
        k = k % n;
        
        if (k == 0) {
            return head;
        }
        
        cur = head;
        for (int i = 1; i < n - k; i++) {
            cur = cur.next;
        }
        
        ListNode newHead = cur.next;
        cur.next = null;
        
        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        
        return newHead;
    }
}