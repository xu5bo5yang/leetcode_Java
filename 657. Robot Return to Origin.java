/**
 * https://leetcode.com/problems/robot-return-to-origin/submissions/
 */
class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() < 1) {
            return true;
        }
        
        int countU = 0;
        int countL = 0;
        
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                countU++;
            } else if (c == 'D') {
                countU--;
            } else if (c == 'L') {
                countL++;
            } else if (c == 'R') {
                countL--;
            }
        }
        
        return countU == 0 && countL == 0;
    }
}