/**
 * https://leetcode.com/problems/length-of-last-word/submissions/
 */
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int length = 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        
        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                break;
            }
        }
        
        return length;
    }
}