/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < 1 || p.length() < 1) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();
        int[] chars = new int[26];
        
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while (right < s.length()) {
            if (chars[s.charAt(right) - 'a'] >= 1) {
                count--;
            }
            
            chars[s.charAt(right) - 'a']--;
            right++;
            
            if (count == 0) {
                result.add(left);
            }
            
            if (right - left == p.length()) {
                if (chars[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                
                chars[s.charAt(left) - 'a']++;
                left++;
            }
        }
        
        return result;
    }
}