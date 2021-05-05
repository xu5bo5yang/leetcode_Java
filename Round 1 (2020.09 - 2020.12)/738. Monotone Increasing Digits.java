/**
 * https://leetcode.com/problems/monotone-increasing-digits/submissions/
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] digits = String.valueOf(N).toCharArray();
        
        int monoEnd = digits.length - 1;
       
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                monoEnd = i - 1;
                digits[i - 1]--;
            }
        }

        for (int i = monoEnd + 1; i < digits.length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}