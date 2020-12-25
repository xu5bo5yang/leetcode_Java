/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/
 */
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = 0;
        
        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] <= target) {
                index = i + 1;
                break;
            }
        }
        
        return letters[index % letters.length];
    }
}