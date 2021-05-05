/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/
 */
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        
        while (left < right) {
            while (left < right && !vowels.contains(s.charAt(left))) {
                left++;
            }
            
            while (left < right && !vowels.contains(s.charAt(right))) {
                right--;
            }
            
            if (right <= left) {
                break;
            }
            
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            
            left++;
            right--;
        }
        
        return String.valueOf(chars);
    }
}