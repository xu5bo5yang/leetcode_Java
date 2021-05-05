/**
 * https://leetcode.com/problems/permutation-in-string/solution/
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        
        Map<Character, Integer> s1Chars = new HashMap();
        Map<Character, Integer> s2Chars = new HashMap();
        
        for (char c : s1.toCharArray()) {
            s1Chars.put(c, s1Chars.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            
            s2Chars.put(c, s2Chars.getOrDefault(c, 0) + 1);
        }
        
        if (s1Chars.equals(s2Chars)) {
            return true;
        }
        
        for (int i = s1.length(); i < s2.length(); i++) {
            char old = s2.charAt(i - s1.length());
            int oldCount = s2Chars.get(old);
            
            if (oldCount == 1) {
                s2Chars.remove(old);
            } else {
                s2Chars.put(old, oldCount - 1);
            }
            
            char newC = s2.charAt(i);
            s2Chars.put(newC, s2Chars.getOrDefault(newC, 0) + 1);
            
            if (s1Chars.equals(s2Chars)) {
                return true;
            }
        }
        
        return false;
    }
}