/**
 * https://leetcode.com/problems/solve-the-equation/submissions/
 */
class Solution {
    public String solveEquation(String equation) {
        if (equation == null || equation.length() < 1) {
            return "No solution";
        }
        
        String[] splitted = equation.split("=", 2);
        int[] left = evaluateString(splitted[0]);
        int[] right = evaluateString(splitted[1]);
        
        left[0] -= right[0];
        right[1] = right[1] - left[1];
        
        if (left[0] == 0 && right[1] == 0) {
            return "Infinite solutions";
        }
        
        if (left[0] == 0) {
            return "No solution";
        }
        
        return "x=" + right[1] / left[0];
    }
    
    int[] evaluateString(String s) {
        String[] splitted = s.split("(?=[-+])");
        int[] result = new int[2];
        
        for (String token : splitted) {
            if (token.equals("-x")) {
                result[0]--;
            } else if (token.equals("x") || token.equals("+x")) {
                result[0]++;
            } else if (token.contains("x")) {
                result[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            } else {
                result[1] += Integer.parseInt(token);
            }
        }
        
        return result;
    }
}