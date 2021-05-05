/**
 * https://leetcode.com/problems/ones-and-zeroes/submissions/
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] result = new int[m+1][n+1];
        
        for (String s : strs) {
            int[] count = count(s);
            
            for (int i = m; i >= count[0]; i--) {
                for (int j = n;j >= count[1]; j--) {
                    result[i][j] = Math.max(result[i][j], result[i-count[0]][j-count[1]] + 1);
                }
            }
        }
        
        return result[m][n];
    }

    int[] count(String s) {
        int[] result = new int[2];
        
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - '0']++;
        }
        
        return result;
     }
}