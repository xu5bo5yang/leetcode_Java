/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/submissions/
 */
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        
        for (String word : d) {
            int i = 0;
            
            for (char c : s.toCharArray()) {
                if (i < word.length() && c == word.charAt(i)) {
                    i++;
                }
            }

            if (i == word.length() && result.length() <= word.length()) {
                if (result.length() < word.length() || word.compareTo(result) < 0) {
                    result = word;
                }
            }
        }
        
        return result;
    }
}
