/**
 * https://leetcode.com/problems/palindrome-number/submissions/
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int reversed = getReversePositiveInt(x);
            
            if (reversed == x) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    int getReversePositiveInt(int x) {
        if (x == 0) {
            return 0;
        } else {
            int result = 0;
            int i = 0;
            while (x > 0) {
                result = result * 10 + x % 10;
                x = x / 10;
                i++;
            }
            
            return result;
        }
    }
}