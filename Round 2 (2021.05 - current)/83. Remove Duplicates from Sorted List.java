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
        if (head == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
                continue;
            }
            
            slow.next = fast;
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = null;
        
        return head;
    }
}