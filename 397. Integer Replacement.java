/**
 * https://leetcode.com/problems/integer-replacement/submissions/
 */
class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        
        int result = 0;
        
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                if (n - 1 != 2 && (n + 1) % 4 == 0) {
                    n++;
                } else {
                    n--;
                }
            }
            
            result++;
        }
        
        return result;
    }
}