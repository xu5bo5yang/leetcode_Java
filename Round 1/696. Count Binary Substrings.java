/**
 * https://leetcode.com/problems/count-binary-substrings/submissions/
 */
class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int cur = 1;
        int result = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                result += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        
        return result + Math.min(cur, pre);
    }
}