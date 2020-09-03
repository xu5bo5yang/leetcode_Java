/**
 * https://leetcode.com/problems/string-to-integer-atoi/submissions/
 */
class Solution {
    public int myAtoi(String str) {
        int result = 0;
        int i = 0;
        int flag = 1;
        
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        
        if (i < str.length() && str.charAt(i) == '+') {
            i++;
        } else if (i < str.length() && str.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int diff = str.charAt(i) - '0';
            
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && diff > Integer.MAX_VALUE % 10)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                result = result * 10 + diff;
            }
            
            i++;
        }
        
        return result * flag;
    }
}