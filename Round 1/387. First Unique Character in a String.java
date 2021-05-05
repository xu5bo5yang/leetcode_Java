/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
 */
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charFreq = new HashMap();
        
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (charFreq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
}