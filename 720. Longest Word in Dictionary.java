/**
 * https://leetcode.com/problems/longest-word-in-dictionary/submissions/
 */
class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length < 1) {
            return "";
        }
        
        String result = "";
        Set<String> dict = new HashSet();
        
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        
        for (String word : words) {
            String sub = word.substring(0, word.length() - 1);
            
            if (word.length() == 1 || dict.contains(sub)) {
                if (word.length() > result.length()) {
                    result = word;
                } else if (word.length() == result.length()) {
                    result = word.compareTo(result) < 0 ? word : result;
                }
                
                dict.add(word);
            }
        }
        
        return result;
    }
}