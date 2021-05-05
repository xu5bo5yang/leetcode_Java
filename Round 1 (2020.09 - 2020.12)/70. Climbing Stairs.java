/**
 * https://leetcode.com/problems/climbing-stairs/submissions/
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        
        int[] results = new int[n];
        results[n-1] = 1;
        results[n-2] = 2;
        
        for (int i = n - 3; i >= 0; i--) {
            results[i] = results[i+1] + results[i+2];
        }
        
        return results[0];
    }
}