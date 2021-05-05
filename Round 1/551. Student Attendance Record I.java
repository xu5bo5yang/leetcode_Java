/**
 * https://leetcode.com/problems/student-attendance-record-i/submissions/
 */
class Solution {
    public boolean checkRecord(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        
        int absentCount = 0;
        int lateCount = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                lateCount++;
            } else {
                lateCount = 0;
            }
            
            if (c == 'A') {
                absentCount++;
            }
            
            if (lateCount > 2 || absentCount > 1) {
                return false;
            }
        }
        
        return true;
    }
}