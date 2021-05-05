/**
 * https://leetcode.com/problems/3sum-closest/submissions/
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        int i = 0;
        while (i < nums.length) {          
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(currentSum - target);

                if (diff < closest) {
                    closest = diff;
                    result = currentSum;
                }

                if (currentSum == target) {
                    return target;
                } else if (left < right && currentSum < target) {
                    left++;
                } else if (left < right && currentSum > target) {
                    right--;
                }
            }
            
            int currentNum = nums[i];
            while (i < nums.length && nums[i] == currentNum) {
                i++;
            }
        }
        
        return result;
    }
}