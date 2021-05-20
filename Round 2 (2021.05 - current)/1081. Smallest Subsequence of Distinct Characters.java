class Solution {
    public String smallestSubsequence(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int[] count = new int[256];
        boolean[] inResult = new boolean[256];
        Stack<Character> stack = new Stack();
        
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        for (char c : s.toCharArray()) {
            count[c]--;
            
            if (inResult[c]) {
                continue;
            }
            
            while (!stack.isEmpty() && c < stack.peek()) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                
                inResult[stack.pop()] = false;
            }
            
            stack.push(c);
            inResult[c] = true;
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
}