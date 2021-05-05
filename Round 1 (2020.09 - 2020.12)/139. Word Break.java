/**
 * https://leetcode.com/problems/word-break/submissions/
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        int len = s.length();
        boolean[] result = new boolean[len];
        Arrays.fill(result, false);
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                String subString = s.substring(j, i+1);
                
                if (wordDict.contains(subString) && (j == 0 || result[j-1])) {
                    result[i] = true;
                    break;
                }
            }
        }
        
        return result[len - 1];
    }
}