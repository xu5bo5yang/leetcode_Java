/**
 * https://leetcode.com/problems/create-maximum-number/submissions/
 */
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[k];
        
        for (int i = Math.max(0, k - m); i <= k && i <= n; i++) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }
        
        return result;
    }
        
    boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int i = 0;
        int j = 0;
        
        for (int r = 0; r < k; r++) {
            if (greater(nums1, i, nums2, j)) {
                result[r] = nums1[i];
                i++;
            } else {
                result[r] = nums2[j];
                j++;
            }
        }
        
        return result;
    }
    
    int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && result[j - 1] < nums[i]) {
                j--;
            }
            
            if (j < k) {
                result[j] = nums[i];
                j++;
            }
        }
        
        return result;
    }
}