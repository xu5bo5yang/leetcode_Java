/**
 * https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int firstDigit;
        int secondDigit;
        int overTen = 0;
        
        ListNode headNode = new ListNode(0);
        ListNode currentNode = headNode;
        
        while (l1 != null || l2 != null) {  
            firstDigit = 0;
            secondDigit = 0;
            
            if (l1 != null) {
                firstDigit = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                secondDigit = l2.val;
                l2 = l2.next;
            }
                
            int sum = firstDigit + secondDigit + overTen;
            overTen = sum / 10;
            
            currentNode.next = new ListNode(sum%10);
            currentNode = currentNode.next;
        }
        
        if (overTen == 1) {
            currentNode.next = new ListNode(overTen);
        }
        
        return headNode.next;
    }
}