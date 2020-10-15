/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (!Character.isDigit(c)) {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> resultLeft = diffWaysToCompute(left);
                List<Integer> resultRight = diffWaysToCompute(right);
                
                for (int l : resultLeft) {
                    for (int r : resultRight) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        
        return result;
    }
}