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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast != null) {
            slow = slow.next;
        }
        
        ListNode left = head;
        ListNode right = reverse(slow);
        
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            
            left = left.next;
            right = right.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode pos = head;
        
        while (cur != null) {
            pos = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pos;
        }
        
        return pre;
    }
}
