/**
 * https://leetcode.com/problems/subarray-product-less-than-k/submissions/
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        
        int count = 0;
        int prodcut = 1;
        
        for (int i = 0, j = 0; j < nums.length; j++) {
            prodcut *= nums[j];
            
            while (i <= j && prodcut >= k) {
                prodcut /= nums[i++];
            }
            
            count += j - i + 1;
        }
        
        return count;       
    }
}