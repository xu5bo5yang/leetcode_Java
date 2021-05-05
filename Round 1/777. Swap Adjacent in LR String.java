/**
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/submissions/
 */
class Solution {
    public boolean canTransform(String start, String end) {
        char[] startChar = start.toCharArray();
        char[] endChar = end.toCharArray();
        int s = 0;
        int e = 0;
        
        while (s < start.length() || e < end.length()) {
            while (s < start.length() && startChar[s] == 'X') {
                s++;
            }
            
            while (e < end.length() && endChar[e] == 'X') {
                e++;
            }
            
            if (s == start.length() || e == end.length()) {
                break;
            }
            
            if (startChar[s] != endChar[e]) {
                return false;
            }
            
            if (startChar[s] == 'R' && s > e) {
                return false;
            }
            
            if (startChar[s] == 'L' && s < e) {
                return false;
            }
            
            s++;
            e++;
        }
        
        return s == e;
    }
}