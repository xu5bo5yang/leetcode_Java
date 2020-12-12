/**
 * https://leetcode.com/problems/implement-magic-dictionary/submissions/
 */
class MagicDictionary {

    Map<Integer, Set<String>> wordLengthMap;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        wordLengthMap = new HashMap();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            int len = word.length();
            
            if (!wordLengthMap.containsKey(len)) {
                wordLengthMap.put(len, new HashSet());
            }
            
            wordLengthMap.get(len).add(word);
        }
    }
    
    public boolean search(String searchWord) {
        int len = searchWord.length();
        
        if (!wordLengthMap.containsKey(len)) {
            return false;
        }
        
        for (String s : wordLengthMap.get(len)) {
            int count = 0;
            
            for (int i = 0; i < len; i++) {
                if (searchWord.charAt(i) != s.charAt(i)) {
                    count++;
                }
                
                if (count > 1) {
                    break;
                }
            }
            
            if (count == 1) {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */