/**
 * https://leetcode.com/problems/split-linked-list-in-parts/submissions/
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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        
        for (ListNode node = root; node != null; node = node.next) {
            len++;
        }
        
        int minSize = len / k;
        int extra = len % k;
        ListNode cur = root;
        ListNode prev = null;
        
        for (int i = 0; cur != null && i < k; i++, extra--) {
            parts[i] = cur;
            
            for (int j = 0; j < minSize + (extra > 0 ? 1 : 0); j++) {
                prev = cur;
                cur = cur.next;
            }
            
            prev.next = null;
        }
        
        return parts;    
    }
}