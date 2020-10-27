/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/submissions/
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        
        int result = 10;
        int uniqueDigits = 9;
        int availableDigits = 9;
        
        while (n > 1 && availableDigits > 0) {
            uniqueDigits = uniqueDigits * availableDigits;
            result += uniqueDigits;
            
            availableDigits--;
            n--;
        }
        return result;
    }
}