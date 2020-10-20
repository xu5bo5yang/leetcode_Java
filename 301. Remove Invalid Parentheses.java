/**
 * https://leetcode.com/problems/remove-invalid-parentheses/submissions/
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null) {
            return new ArrayList();
        }
        
        s = s.trim();
        if(s.isEmpty()){
            return Arrays.asList("");
        }
        
        Stack<Character> stack = new Stack<>();
        int invalidLeft = 0;
        int invalidRight = 0;
        
        for (char c : s.toCharArray()){
            if(c == '(') {
                stack.add('(');
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    invalidRight++;
                } else {
                    stack.pop();
                }
            }
        }
        
        invalidLeft = stack.size();
        Set<String> result = new HashSet<>();
        
        search(result, s, 0, invalidLeft, invalidRight);
        
        return result.stream().collect(Collectors.toList());
    }
    
    void search(Set<String> result, String s, int index, int invalidLeft, int invalidRight){
        if(invalidLeft == 0 && invalidRight == 0) {
            Stack<Character> stack = new Stack<>();
            
            for (char c : s.toCharArray()){
                if(c == '(') {
                    stack.add('(');
                } else if(c == ')') {
                    if(stack.isEmpty()) {
                        invalidRight++;
                    } else {
                        stack.pop();
                    }
                }
            }
            
            invalidLeft += stack.size();
            
            if(invalidLeft == 0 && invalidRight == 0){
                result.add(s);
            }
            
            return;
        }
        
        if(index == s.length()) {
            return;
        }
        
        if(s.charAt(index) == '(' && invalidLeft > 0){
            search(result, s.substring(0,index) + s.substring(index+1), index, invalidLeft-1, invalidRight);
            search(result, s, index+1, invalidLeft, invalidRight);
        } else if(s.charAt(index) == ')' && invalidRight > 0){
            search(result, s.substring(0,index) + s.substring(index+1), index, invalidLeft, invalidRight-1);
            search(result, s, index+1, invalidLeft, invalidRight);
        } else{
            search(result, s, index+1, invalidLeft, invalidRight);
        }
    }
}