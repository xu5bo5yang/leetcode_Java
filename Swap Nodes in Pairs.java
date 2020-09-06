/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
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
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0, head);
        ListNode cur = result;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            
            cur = cur.next.next;
        }
        
        return result.next;
    }
}