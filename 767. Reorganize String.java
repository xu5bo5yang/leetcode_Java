/**
 * https://leetcode.com/problems/reorganize-string/submissions/
 */
class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() < 1) {
            return "";
        }
        
        int[] count = new int[26];
        char mostCommon = S.charAt(0);
        int mostCount = 0;
        char[] result = new char[S.length()];
        
        for (char c : S.toCharArray()) {
            count[c - 'a']++;
            
            if (count[c - 'a'] > mostCount) {
                mostCommon = c;
                mostCount = count[c - 'a'];
            }
        }
        
        if (mostCount > (S.length() + 1) / 2) {
            return "";
        }
        
        int index = 0;
        
        while (index < S.length() && count[mostCommon - 'a'] > 0) {
            result[index] = mostCommon;
            count[mostCommon - 'a']--;
            index += 2;
        }
        
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                if (index >= S.length()) {
                    index = 1;
                }
                
                result[index] = (char) ('a' + i);
                count[i]--;
                index += 2;
            }
        }
        
        return new String(result);
    }
}