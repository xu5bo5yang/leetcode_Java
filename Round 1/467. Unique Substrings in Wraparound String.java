/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/submissions/
 */
class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() < 1) {
            return 0;
        }
        
        int[] count = new int[26];
        char[] chars = p.toCharArray();
        
        for (int i = 0; i < p.length(); i++) {
            int cur = 1;
            int j = i;
            
            while (j - 1 >= 0 && (chars[j] - chars[j - 1] == 1 || chars[j] - chars[j - 1] == -25)) {
                cur++;
                j--;
            }
            
            count[chars[i] - 'a'] = Math.max(count[chars[i] - 'a'], cur);
        }
        
        int result = 0;
        
        for (int i = 0; i < count.length; i++) {
            result += count[i];
        }
        
        return result;
    }
}