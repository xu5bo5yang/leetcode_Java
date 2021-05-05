/**
 * https://leetcode.com/problems/repeated-string-match/submissions/
 */
class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (b == null || b.length() < 1) {
            return 0;
        }
        
        if (a == null || a.length() < 1) {
            return -1;
        }
        
        StringBuilder sb = new StringBuilder();
        int result = 0;
        
        while (sb.length() <= a.length() + b.length()) {
            sb.append(a);
            result++;
            
            if (sb.indexOf(b) != -1) {
                return result;
            }
        }
        
        return -1;
    }
}