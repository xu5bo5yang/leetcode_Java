/**
 * https://leetcode.com/problems/2-keys-keyboard/submissions/
 */
class Solution {
    public int minSteps(int n) {
        int result = 0;
        
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                result += i;
                n = n / i;
            }
        }
        
        return result;
    }
}