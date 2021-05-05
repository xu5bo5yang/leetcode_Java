/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        
        ListNode result = new ListNode(0, head);
        ListNode dummy = result;
        
        while(dummy != null) {
            ListNode tmp = dummy;
            
            for (int count = 0; count < k && tmp != null; count++) {
                tmp = tmp.next;
            }
            
            if (tmp == null) {
                break;
            }
            
            ListNode first = null;
            ListNode cur = dummy.next;
            ListNode next = null;
            
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = first;
                first = cur;
                cur = next;
            }
            
            ListNode tail = dummy.next;
            tail.next = cur;
            dummy.next = first;
            dummy = tail;
        }
        
        return result.next;
    }
}