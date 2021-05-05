/**
 * https://leetcode.com/problems/number-of-matching-subsequences/submissions/
 */
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        
        int result = 0;
        List<StringBuilder>[] wordLists = new List[26];
        
        for (int i = 0; i < 26; i++) {
            wordLists[i] = new ArrayList();
        }
        
        for (String w : words) {
            wordLists[w.charAt(0) - 'a'].add(new StringBuilder(w));
        }

        for (char c : S.toCharArray()) {
            List<StringBuilder> wordList = wordLists[c - 'a'];

            wordLists[c - 'a'] = new ArrayList();

            for (StringBuilder sb : wordList){
                sb.deleteCharAt(0);
                
                if(sb.length() != 0) {
                    wordLists[sb.charAt(0) - 'a'].add(sb);
                } else {
                    result++;
                }
            }
        }
        
        return result;
    }
}