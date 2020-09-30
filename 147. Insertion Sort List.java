/**
 * https://leetcode.com/problems/insertion-sort-list/submissions/
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
    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(0, head);
        ListNode tail = head;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            
            if (tmp.val >= tail.val) {
                tail.next = tmp;
                tail = tmp;
                tail.next = null;
            } else {
                ListNode index = result;
                while (index != tail && tmp.val > index.next.val) {
                    index = index.next;
                }

                tmp.next = index.next;
                index.next = tmp;
            }
        }
        
        return result.next;
    }
}