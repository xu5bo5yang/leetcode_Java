/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        int lastIndex = 0;
        char[] chArray = s.toCharArray();

        for (int i = 0; i < chArray.length; i++) {
            char ch = chArray[i];
            if (charMap.containsKey(ch)) {
                lastIndex = Math.max(charMap.get(ch), lastIndex);
            }
            
            maxLength = Math.max(maxLength, i-lastIndex+1);            
            charMap.put(ch, i+1);
        }
    
        return maxLength;
    }
};