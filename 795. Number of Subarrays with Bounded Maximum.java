/**
 * https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/submissions/
 */
class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A == null || A.length < 1 || L > R) {
            return 0;
        }
        
        int left = -1;
        int right = -1;
        int result = 0;
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                left = i;
                right = left;
                continue;
            }
            
            if (A[i] >= L) {
                right = i;
            }
            
            result += right - left;
        }
        
        return result;
    }
}