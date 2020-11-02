/**
 * https://leetcode.com/problems/decode-string/submissions/
 */
class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> countStack = new Stack();
        Stack<String> stringStack = new Stack();
        int index = 0;
        
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                stringStack.push(result.toString());
                result.setLength(0);
                index++;
            } else if (s.charAt(index) == ']') {
                int count = countStack.pop();
                String prev = stringStack.pop();
                String cur = result.toString();
                
                result.insert(0, prev);
                for (int i = 0; i < count - 1; i++) {
                    result.append(cur);
                }
                
                index++;
            } else {
                result.append(s.charAt(index));
                index++;
            }
        }
        
        return result.toString();
    }
}