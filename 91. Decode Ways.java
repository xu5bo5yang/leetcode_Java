/**
 * https://leetcode.com/problems/decode-ways/submissions/
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 1;
        }
        
        int l = s.length();
        int[] result = new int[l+1];
        result[l] = 1;
        
        for (int i = l-1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                result[i] = result[i+1];
                
                if (i < l-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
                    result[i] += result[i+2];
                }
            }
        }
        
        return result[0];
    }
}