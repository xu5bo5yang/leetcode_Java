/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/submissions/
 */
class Solution {
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        Arrays.sort(nums);

        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            result += nums[right] - nums[left];
            
            left++;
            right--;
        }  
        
        return result;
    }
}