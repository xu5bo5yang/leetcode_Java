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
        
        ListNode left = head;
        ListNode right = head;
        
        for (int i = 0; i < k; i++) {
            if (right == null) {
                return left;
            }
            
            right = right.next;
        }
        
        ListNode newHead = reverseK(left, right);
        left.next = reverseKGroup(right, k);
        
        return newHead;
    }
    
    private ListNode reverseK(ListNode l, ListNode r) {
        ListNode pre = null;
        ListNode cur = l;
        ListNode pos = l;
        
        while (cur != r) {
            pos = cur.next;
            cur.next = pre; 
            pre = cur;
            cur = pos;
        }
        
        return pre;
    }
}
