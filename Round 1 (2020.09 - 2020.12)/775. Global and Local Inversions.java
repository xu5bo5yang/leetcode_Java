/**
 * https://leetcode.com/problems/global-and-local-inversions/submissions/
 */
class Solution {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length < 1) {
            return false;
        }
        
        int max = 0;
        
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);
            
            if (A[i + 2] < max) {
                return false;
            }
        }
        
        return true;
    }
}