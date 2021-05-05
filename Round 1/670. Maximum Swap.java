/**
 * https://leetcode.com/problems/maximum-swap/submissions/
 */
class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] count = new int[10];
        
        for (int i = 0; i < digits.length; i++) {
            count[digits[i] - '0'] = i;
        }
        
        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {
                if (count[j] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[count[j]];
                    digits[count[j]] = tmp;
                    
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        return num;
    }
}