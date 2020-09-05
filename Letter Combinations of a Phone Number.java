/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<String>();
        }
        
        List<String> result = new ArrayList<String>();
        result.add("");
        
        Map<Character, List<Character>> digitToChar = new HashMap<>();
        digitToChar.put('2', Arrays.asList('a', 'b', 'c'));
        digitToChar.put('3', Arrays.asList('d', 'e', 'f'));
        digitToChar.put('4', Arrays.asList('g', 'h', 'i'));
        digitToChar.put('5', Arrays.asList('j', 'k', 'l'));
        digitToChar.put('6', Arrays.asList('m', 'n', 'o'));
        digitToChar.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitToChar.put('8', Arrays.asList('t', 'u', 'v'));
        digitToChar.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        
        for (char ch : digits.toCharArray()) {
            List<Character> possibleChars = digitToChar.get(ch);
            
            result = generateWithPossibleChars(result, possibleChars);
        }
        
        return result;
    }
    
    List<String> generateWithPossibleChars(List<String> current, List<Character> candidates) {
        List<String> result = new ArrayList<String>();
        
        for (String s : current) {
            for (char ch : candidates) {
                result.add(s + ch);
            }
        }
        
        return result;
    }
}