/**
 * https://leetcode.com/problems/reverse-integer/submissions/
 */
class Solution {
    public int reverse(int x) {
        int sign = 1;
        
        if (x == 0) {
            return x;
        } else if (x < 0) {
            sign = -1;
            x = -1 * x;
        } 
        
        int result = 0;
        int i = 0;
        
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)) {
                result = 0;
                break;
            }
            
            result = result * 10 + x % 10;
            x = x / 10;
            i++;
        }
        
        return result * sign;
    }
}