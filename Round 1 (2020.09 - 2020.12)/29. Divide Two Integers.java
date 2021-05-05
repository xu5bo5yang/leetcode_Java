/**
 * https://leetcode.com/problems/divide-two-integers/submissions/
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int quotient = 0;
        int sign = 0;
        
        if ((dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        } else {
            sign = -1;
        }
        
        if (dividend > 0) {
            dividend = -dividend;
        }
        
        if (divisor > 0) {
            divisor = -divisor;
        }
        
        quotient = recursiveDivide(dividend, divisor);
        
        return sign == 1 ? quotient : -quotient;
    }
    
    int recursiveDivide(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        
        int binaryDivisor = divisor;
        int times = 1;
        
        while ((dividend < binaryDivisor + binaryDivisor) && (binaryDivisor > Integer.MIN_VALUE - binaryDivisor)) {
            times += times;
            binaryDivisor += binaryDivisor;
        }
        
        return times + recursiveDivide(dividend - binaryDivisor, divisor);
    }
}