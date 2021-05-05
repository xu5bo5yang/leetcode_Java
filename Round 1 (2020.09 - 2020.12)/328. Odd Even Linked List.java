/**
 * https://leetcode.com/problems/odd-even-linked-list/submissions/
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
    public ListNode oddEvenList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode evenNodeHead = new ListNode(0);
        
        ListNode odd = result;
        ListNode even = evenNodeHead;
        int count = 1;
        
        while (head != null) {
            if (count % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            
            count++;
            head = head.next;
        }
        
        odd.next = evenNodeHead.next;
        even.next = null;
        
        return result.next;
    }
}