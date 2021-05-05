/**
 * https://leetcode.com/problems/parse-lisp-expression/submissions/
 */
class Solution {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap());
    }
    
    int evaluate(String expression, Map<String, Integer> parent) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            }
            
            return parent.get(expression);
        }
        
        Map<String, Integer> cur = new HashMap();
        cur.putAll(parent);
        
        int start = (expression.substring(1, 5).equals("mult")) ? 6 : 5;
        
        List<String> tokens = parse(expression.substring(start, expression.length() - 1));
        
        if (expression.substring(1, 5).equals("mult")) {
            return evaluate(tokens.get(0), cur) * evaluate(tokens.get(1), cur);
        }
        else if (expression.substring(1, 4).equals("add")) {
            return evaluate(tokens.get(0), cur) + evaluate(tokens.get(1), cur); 
        }
        else if (expression.substring(1, 4).equals("let")) {
            for (int i = 0; i < tokens.size() - 2; i += 2) {
                cur.put(tokens.get(i), evaluate(tokens.get(i + 1), cur));
            }
            return evaluate(tokens.get(tokens.size() - 1), cur);
        }
        return -1; 
    }
    
    List<String> parse(String expression) {
        List<String> tokens = new ArrayList();
        int leftParenthesis = 0;
        StringBuilder sb = new StringBuilder();
        
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                leftParenthesis++;
            }
            else if (c == ')') {
                leftParenthesis--;
            }
            if (c == ' ' && leftParenthesis == 0) {
                tokens.add(sb.toString());
                sb = new StringBuilder();
            }
            else {
                sb.append(c);
            }
        }
        
        if (sb.length() > 0) {
            tokens.add(sb.toString());
        }
        
        return tokens; 
    }
}