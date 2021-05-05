/**
 * https://leetcode.com/problems/number-of-digit-one/submissions/
 */
class Solution {
    public int countDigitOne(int n) {
        int result = 0;
        
        for (long i = 1; i <= n; i *= 10) {
            long count = n / i; 
            long remain = n % i;
            
            result += (count + 8) / 10 * i + (count % 10 == 1 ? remain + 1 : 0);
        }
        
        return result;
    }
}