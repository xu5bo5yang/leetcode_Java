/**
 * https://leetcode.com/problems/generate-parentheses/submissions/
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        int left = 0;
        int right = 0;
        
        expand(result, "", left, right, n);
        
        return result;
    }
    
    void expand(List<String> result, String s, int left, int right, int n) {
        if (s.length() == n * 2) {
            result.add(s);
        } else {
            if (left < n) {
                expand(result, s+'(', left+1, right, n);
            }

            if (right < left) {
                expand(result, s+')', left, right+1, n);
            }
        }
    }
}