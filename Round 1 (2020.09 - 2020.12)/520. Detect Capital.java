/**
 * https://leetcode.com/problems/detect-capital/submissions/
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() < 1) {
            return true;
        }
        
        int capitalCount = 0;
        boolean firstLetterCapital = Character.isUpperCase(word.charAt(0));
        
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitalCount++;
            }
        }
        
        if (firstLetterCapital) {
            return capitalCount == 1 || capitalCount == word.length();
        } else {
            return capitalCount == 0;
        }
    }
}
