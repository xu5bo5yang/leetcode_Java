/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/
 */
class WordDictionary {
    
    Map<Integer, Set<String>> dict = new HashMap<>();

    /** Initialize your data structure here. */
    public WordDictionary() {
        dict = new HashMap();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();
        Set<String> words = dict.getOrDefault(len, new HashSet());
        words.add(word);
        
        dict.put(len, words);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int len = word.length();
        Set<String> words = dict.getOrDefault(len, new HashSet());
        
        for (String pre : words) {
            int i = 0;
            while (i < len) {
                if (word.charAt(i) != '.' && pre.charAt(i) != word.charAt(i)) {
                    break;
                }
                
                i++;
            }
            
            if (i == len) {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */