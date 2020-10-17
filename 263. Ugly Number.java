/**
 * https://leetcode.com/problems/ugly-number/submissions/
 */
class Solution {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        
        while (num > 1) {
            if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0) {
                return false;
            }
            
            if (num % 2 == 0) {
                num /= 2;
            }
            
            if (num % 3 == 0) {
                num /= 3;
            }
            
            if (num % 5 == 0) {
                num /= 5;
            }
        }
        
        return true;
    }
}