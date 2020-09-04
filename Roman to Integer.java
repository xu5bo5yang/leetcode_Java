/**
 * https://leetcode.com/problems/roman-to-integer/submissions/
 */
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int[] number={1000, 500, 100, 50, 10, 5, 1};
        String[] roman={"M", "D", "C", "L", "X", "V", "I"};
        int result = 0;
        
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'M') {
                result += 1000;
            } else if (s.charAt(i) == 'D') {
                result += 500;
            } else if (s.charAt(i) == 'C') {
                if ((i+1) >= s.length()) {
                    result += 100;
                } else if (s.charAt(i+1) == 'M' || s.charAt(i+1) == 'D') {
                    result -= 100;
                } else {
                    result += 100;
                }
            } else if (s.charAt(i) == 'L') {
                result += 50;
            } else if (s.charAt(i) == 'X') {
                if ((i+1) >= s.length()) {
                    result += 10;
                } else if (s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L') {
                    result -= 10;
                } else {
                    result += 10;
                }
            } else if (s.charAt(i) == 'V') {
                result += 5;
            } else if (s.charAt(i) == 'I') {
                if ((i+1) >= s.length()) {
                    result += 1;
                } else if (s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V') {
                    result -= 1;
                } else {
                    result += 1;
                }
            }
            
            i++;
        }
        
        return result;
    }
}