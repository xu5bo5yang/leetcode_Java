/**
 * https://leetcode.com/problems/concatenated-words/submissions/
 */
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length < 1) {
            return new ArrayList();
        }
        
        List<String> result = new ArrayList();
        HashSet<String> wordSet = new HashSet(Arrays.asList(words));
        HashSet<String> nonCombination = new HashSet();
        
        for (String word : words) {
            if (canForm(word, wordSet, nonCombination)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    boolean canForm(String word, HashSet<String> wordSet, HashSet<String> nonCombination) {
        if (nonCombination.contains(word)) {
            return false;
        }
        
        for (int i = 1; i < word.length(); i++) {
            if (wordSet.contains(word.substring(0, i))) {
                String suffix = word.substring(i);
                
                if (wordSet.contains(suffix) || canForm(suffix, wordSet, nonCombination)) {
                    wordSet.add(word);
                    
                    return true;
                }
            }
        }
        
        nonCombination.add(word);
        
        return false;
    }
}