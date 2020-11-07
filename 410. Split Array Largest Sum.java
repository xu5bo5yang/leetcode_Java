/**
 * https://leetcode.com/problems/split-array-largest-sum/submissions/
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length < m) {
            return 0;
        }
        
        long sum = 0;
        int maxNum = 0;
        
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        
        return (int)binarySearch(nums, m, maxNum, sum);
    }
    
    long binarySearch(int[] nums, int m, long low, long high) {
        while (low < high) {
            long mid = low + (high - low) / 2;
            
            if (isValidSum(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return high;
    }
    
    boolean isValidSum(int[] nums, int m, long sum) {
        long total = 0;
        int count = 1;
        
        for (int num : nums) {
            total += num;
            
            if (sum < total) {
                total = num;
                count++;
                
                if (m < count) {
                    return false;
                }
            }
        }
        
        return true;
    }
}