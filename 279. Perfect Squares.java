/**
 * https://leetcode.com/problems/perfect-squares/submissions/
 */
class Solution {
    public int numSquares(int n) {
        int[] result = new int[n+1];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        
        result[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                result[i] = Math.min(result[i], result[i - j * j] + 1);
            }
        }
        return result[n];
    }
}