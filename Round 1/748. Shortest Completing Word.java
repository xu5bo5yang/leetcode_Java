/**
 * https://leetcode.com/problems/shortest-completing-word/submissions/
 */
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (licensePlate == null || licensePlate.length() < 1 || words == null || words.length < 1) {
            return "";
        }
        
        Map<Character, Integer> charCount = new HashMap();
        String result = "";
        int minLength = Integer.MAX_VALUE;
        
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        
        for (String word : words) {
            if (word.length() >= minLength) {
                continue;
            }
            
            Map<Character, Integer> wordCharCount = new HashMap();
            wordCharCount.putAll(charCount);
            
            for (char c : word.toCharArray()) {
                wordCharCount.put(c, wordCharCount.getOrDefault(c, 0) - 1);
                
                if (wordCharCount.get(c) <= 0) {
                    wordCharCount.remove(c);
                }
            }
            
            if (wordCharCount.isEmpty()) {
                result = word;
                minLength = word.length();
            }
        }
        
        return result;
    }
}