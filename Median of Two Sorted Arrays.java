/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if ((m+n) % 2 == 0) {
            int left = findPthSmallest(nums1, nums2, (m+n)/2);
            int right = findPthSmallest(nums1, nums2, (m+n)/2+1);
            
            return (double)(left+right)/2;
        } else {
            return findPthSmallest(nums1, nums2, (m+n)/2+1);
        }
    }
    
    int findPthSmallest(int[] nums1, int[] nums2, int p) {
        int result = 0;
        int m = 0;
        int n = 0;
        
        for (int i = 0; i < p; i++) {
            if (m == nums1.length) {
                result = nums2[n];
                n++;
            } else if (n == nums2.length) {
                result = nums1[m];
                m++;
            } else if (nums1[m] <= nums2[n]) {
                result = nums1[m];
                m++;
            } else {
                result = nums2[n];
                n++;
            }
        }
        
        return result;
    }
}