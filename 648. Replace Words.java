/**
 * https://leetcode.com/problems/replace-words/submissions/
 */
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        if (sentence == null || sentence.length() < 1) {
            return sentence;
        }
        
        dictionary.sort((a, b) -> a.length() - b.length());
        
        String[] words = sentence.split("\\s+");
        
        for (int i = 0; i < words.length; i++) {
            for (String root: dictionary) {
                if (words[i].startsWith(root)) {
                    words[i] = root;
                    break;
                }
            }
        }
        
        return String.join(" ", words);
    }
}