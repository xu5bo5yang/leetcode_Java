/**
 * https://leetcode.com/problems/sliding-window-maximum/submissions/
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> window = new LinkedList();
        
        for (int i = 0; i < nums.length; i++) {
            while (window.size() > 0 && window.peekFirst() <= i - k) {
                window.pollFirst();
            }

            while (window.size() > 0 && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            window.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[window.peekFirst()];
            }
        }
        
        return result;
    }
}