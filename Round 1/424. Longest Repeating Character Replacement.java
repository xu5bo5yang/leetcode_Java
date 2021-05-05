/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/submissions/
 */
class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        int len = s.length();
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int maxLength = 0;
        
        for (int end = 0; end < len; end++) {
            count[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']);
            
            while (k < end - start + 1 - maxCount) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}