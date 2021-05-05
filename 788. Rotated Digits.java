/**
 * https://leetcode.com/problems/rotated-digits/submissions/
 */
class Solution {
    public int rotatedDigits(int N) {
        if (N < 2) {
            return 0;
        }
        
        int count = 0;
        
        for (int i = 2; i <= N; i++) {
            if (isValid(i)) {
                count++;
            }
        }
        
        return count;
    }
    
    boolean isValid(int N) {
        boolean hasValidDigit = false;
        
        while (N > 0) {
            switch (N % 10) {
                case 2:
                case 5:
                case 6:
                case 9:
                    hasValidDigit = true;
                    break;
                case 3:
                case 4:
                case 7:
                    return false;
            }
            
            N = N / 10;
        }
        
        return hasValidDigit;
    }
}