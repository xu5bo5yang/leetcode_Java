/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet();
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else if (visited.contains(headA)) {
                return headA;
            } else if (visited.contains(headB)) {
                return headB;
            }
            
            visited.add(headA);
            visited.add(headB);
            
            headA = headA.next;
            headB = headB.next;
        }
        
        if (headA == null) {
            headA = headB;
        }
        
        while (headA != null) {
            if (visited.contains(headA)) {
                return headA;
            }
            
            headA = headA.next;
        }
        
        return null;
    }
}