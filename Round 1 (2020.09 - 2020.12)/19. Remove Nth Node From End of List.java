/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> nodeIndex = new HashMap<>();
        int i = 1;
        
        ListNode curNode = head;
        while (curNode != null) {
            nodeIndex.put(i, curNode);
            curNode = curNode.next;
            i++;
        }
        
        int total = i-1;
        
        if (n == total) {
            head = head.next;
        } else {
            nodeIndex.get(total-n).next = nodeIndex.get(total-(n-1)).next;
        }
        
        
        return head;
    }
}