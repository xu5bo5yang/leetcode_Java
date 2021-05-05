/**
 * https://leetcode.com/problems/total-hamming-distance/submissions/
 */
class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            int count = 0;
            
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            
            result += count * (nums.length - count);
        }
        
        return result;
    }
}
