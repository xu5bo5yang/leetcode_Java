/**
 * https://leetcode.com/problems/reorder-list/submissions/
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        Map<Integer, ListNode> indexNodeMap = new HashMap();
        ListNode cur = head;
        
        int i = 0;
        while (cur != null) {
            indexNodeMap.put(i, cur);
            
            cur = cur.next;
            i++;
        }
        
        int len = i;
        ListNode result = new ListNode(0);
        cur = result;
        for (i = 0; i < len / 2; i++) {
            cur.next = indexNodeMap.get(i);
            cur = cur.next;
            cur.next = indexNodeMap.get(len-i-1);
            cur = cur.next;
        }
        
        if (len % 2 == 1) {
            cur.next = indexNodeMap.get(len/2);
            cur = cur.next;
        }
        
        cur.next = null;
    }
}