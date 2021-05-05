/**
 * https://leetcode.com/problems/rotate-function/submissions/
 */
class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        
        int len = A.length;
        int sum = 0;
        int function = 0;
        
        for (int i = 0; i < len; i++) {
            sum += A[i];
            function += i * A[i];
        }
        
        int result = function;
        
        for (int i = len - 1; i >= 0; i--) {
            function += sum - len * A[i];
            result = Math.max(result, function);
        }
        
        return result;
    }
}