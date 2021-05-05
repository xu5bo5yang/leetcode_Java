/**
 * https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/submissions/
 */
class Solution {
    public int findIntegers(int num) {
        if (num < 1) {
            return 0;
        }
        
        String numStr = new StringBuilder(Integer.toBinaryString(num)).reverse().toString();
        int len = numStr.length();
        int[] zero = new int[len];
        int[] one = new int[len];
        
        zero[0] = 1;
        one[0] = 1;
        
        for (int i = 1; i < len; i++) {
            zero[i] = zero[i - 1] + one[i - 1];
            one[i] = zero[i - 1];
        }
        
        int result = zero[len - 1] + one[len - 1];
        
        for (int i = len - 2; i >= 0; i--) {
            if (numStr.charAt(i) == '1' && numStr.charAt(i + 1) == '1') {
                break;
            }
            
            if (numStr.charAt(i) == '0' && numStr.charAt(i + 1) == '0') {
                result -= one[i];
            }
        }
        
        return result;
    }
}