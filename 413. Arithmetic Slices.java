/**
 * https://leetcode.com/problems/arithmetic-slices/submissions/
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int[] slices = new int[A.length];
        int result = 0;
        
        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                slices[i] = slices[i - 1] + 1;
                
                result += slices[i];
            }
        }
        
        return result;
    }
}