/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/submissions/
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int[] newNums = nums.clone();
        
        Arrays.sort(newNums);
        
        int start = newNums.length;
        int end = 0;
        
        for (int i = 0; i < newNums.length; i++) {
            if (newNums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}