/**
 * https://leetcode.com/problems/strange-printer/submissions/
 */
class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        int len = s.length();        
        int[][] result = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            result[i][i] = 1;
        }
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                result[j][j + i] = i + 1;
                
                for (int k = j + 1; k <= j + i; k++) {
                    int tmp = result[j][k - 1] + result[k][j + i];
                    
                    if (s.charAt(k - 1) == s.charAt(j + i)) {
                        tmp--;
                    }
                    
                    result[j][j + i] = Math.min(result[j][j + i], tmp);
                }
            }
        }
        
        return result[0][len - 1];
    }
}