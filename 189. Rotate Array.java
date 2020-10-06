/**
 * https://leetcode.com/problems/rotate-array/solution/
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int len = nums.length;
        k = k % len;
        
        if (k == 0) {
            return;
        }
        
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            result[(i+k)%len] = nums[i];
        }
        
        for (int i = 0; i < len; i++) {
            nums[i] = result[i];
        }
        
        return;
    }
}