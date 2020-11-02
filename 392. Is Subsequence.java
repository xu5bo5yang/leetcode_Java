/**
 * https://leetcode.com/problems/is-subsequence/submissions/
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        if (s.isEmpty()) {
            return true;
        } else if (t.isEmpty()) {
            return false;
        }
        
        int indexS = 0;
        int indexT = 0;
        
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                indexT++;
            } else {
                indexT++;
            }
        }
        
        return indexS == s.length();
    }
}