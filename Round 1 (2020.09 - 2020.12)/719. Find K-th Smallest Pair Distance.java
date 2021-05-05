/**
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/submissions/
 */
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        Arrays.sort(nums);
    
        int len = nums.length;
        int left = 0;
        int right = nums[len - 1] - nums[0];

        for (int count = 0; left < right; count = 0) {
            int mid = left + (right - left) / 2;

            for (int i = 0, j = 0; i < len; i++) {
                while (j < len && nums[j] <= nums[i] + mid) {
                    j++;
                }
                
                count += j - i - 1;
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}