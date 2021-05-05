/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/submissions/
 */
class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        String[] splitted = s.split(" ");
        int result = splitted.length;
        
        for (String str : splitted) {
            if (str.isEmpty()) {
                result--;
            }
        }
        
        return result;
    }
}