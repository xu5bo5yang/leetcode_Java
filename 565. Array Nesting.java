/**
 * https://leetcode.com/problems/array-nesting/submissions/
 */
class Solution {
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int len = 1;
                int cur = nums[i];

                while (Math.abs(cur) != i) {
                    len++;
                    cur = nums[Math.abs(cur)];

                    if (nums[Math.abs(cur)] > 0)
                        nums[Math.abs(cur)] *= -1;
                }

                result = Math.max(result, len);
            }
        }

        return result;
    }
}