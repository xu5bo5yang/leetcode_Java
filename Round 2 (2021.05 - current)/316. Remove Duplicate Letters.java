class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inResult = new boolean[26];
        Stack<Character> stack = new Stack();
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            
            if (inResult[c - 'a']) {
                continue;
            }
            
            while (!stack.isEmpty() && c < stack.peek()) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                
                inResult[stack.pop() - 'a'] = false;
            }
            
            stack.push(c);
            inResult[c - 'a'] = true;
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }
}