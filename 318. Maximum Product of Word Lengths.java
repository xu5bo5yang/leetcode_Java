/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/submissions/
 */
class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        
        for(int i = 0; i < words.length; i++) {
            Set<Character> letters = new HashSet();
            String word = words[i];
            
            for(char c : word.toCharArray()) {
                letters.add(c);
            }
            
            for(int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                boolean hasCommonLetter = false;
                
                for(char c : word2.toCharArray()) {
                    if(letters.contains(c)) {
                        hasCommonLetter = true;
                        break;
                    }
                }
                
                if(!hasCommonLetter) {
                    result = Math.max(word.length() * word2.length(), result);
                }
            }
        }
        
        return result;
    }
}