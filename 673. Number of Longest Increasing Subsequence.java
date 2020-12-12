/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/submissions/
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
                
        int result = 0;
        int len = nums.length;
        int max = 0;
        int[] lens =  new int[len];
        int[] count = new int[len];
        
        for (int i = 0; i < len; i++) {
            lens[i] = 1;
            count[i] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lens[i] == lens[j] + 1) {
                        count[i] += count[j];
                    }
                    
                    if (lens[i] < lens[j] + 1) {
                        lens[i] = lens[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            
            if (max == lens[i]) {
                result += count[i];
            }
            
            if (max < lens[i]) {
                max = lens[i];
                result = count[i];
            }
        }
        
        return result;
    }
}