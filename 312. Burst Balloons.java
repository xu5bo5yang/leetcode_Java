/**
 * https://leetcode.com/problems/burst-balloons/submissions/
 */
class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        int n = 1;
        
        newNums[0] = 1;
        for (int x : nums) {
            if (x > 0) {
                newNums[n] = x;
                n++;
            }
        }
        newNums[n] = 1;
        n++;

        int[][] result = new int[n][n];
        
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                
                for (int i = left + 1; i < right; i++) {
                    result[left][right] = Math.max(result[left][right], 
                    newNums[left] * newNums[i] * newNums[right] + result[left][i] + result[i][right]);
                }
            }
        }

        return result[0][n - 1];    
    }
}