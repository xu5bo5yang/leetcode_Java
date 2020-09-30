/**
 * https://leetcode.com/problems/sort-list/submissions/
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode();
        ListNode tail = result;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
                    
        tail.next = (left == null) ? right : left;
        
        return result.next;
    }
    
    ListNode getMid(ListNode head) {
        ListNode slow = null;
        
        while (head != null && head.next != null) {
            slow = slow == null ? head : slow.next;
            head = head.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        
        return mid;
    }
}