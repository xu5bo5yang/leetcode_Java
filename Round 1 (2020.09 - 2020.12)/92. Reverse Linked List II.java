/**
 * https://leetcode.com/problems/reverse-linked-list-ii/submissions/
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(0, head);
        ListNode cur = result;
        ListNode left = cur;
        
        int i = 0;
        while (cur != null && i < m) {
            left = cur;
            cur = cur.next;
            i++;
        }
        
        ListNode right = cur;
        ListNode prev = cur;
        ListNode tmp = cur.next;
        while(cur != null && i < n) {
            cur = tmp;
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            i++;
        }
        
        left.next = prev;
        right.next = tmp;
        
        return result.next;
    }
}