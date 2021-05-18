public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        int left = 0;
        int right = 0;
        int result = 0;
        Map<Character, Integer> window = new HashMap();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            while (window.get(c) > 1) {
                char ch = s.charAt(left);
                left++;
                
                window.put(ch, window.get(ch) - 1);
            }
            
            result = Math.max(result, right - left);
        }
        
        return result;
    }
};