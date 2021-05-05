/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/submissions/
 */
class Solution {
    String[] digitWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    char[] uniqueChars = {'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i'};
    int[] digits = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};

    public String originalDigits(String s) {
        int[] digitCount = new int[10];
        int[] uniqueCharCount = new int[26];
        
        for (char c : s.toCharArray()) {
            uniqueCharCount[c - 'a']++;
        }
        
        for (int digit : digits) {
            digitCount[digit] = uniqueCharCount[uniqueChars[digit] - 'a'];
            
            for (char c : digitWords[digit].toCharArray()) {
                uniqueCharCount[c - 'a'] -= digitCount[digit];
            }
        }
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < digitCount[i]; ++j) {
                result.append(i);
            }
        }
        
        return result.toString();
    }
}