/**
 * https://leetcode.com/problems/linked-list-random-node/submissions/
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
    Map<Integer, ListNode> nodes;
    int size = 0;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        nodes = new HashMap();
        int index = 0;
        
        while (head != null) {
            nodes.put(index, head);
            head = head.next;
            index++;
        }
        
        size = index;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random random = new Random(); 

        return nodes.get(random.nextInt(size)).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */