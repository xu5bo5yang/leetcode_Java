/** 
 * https://leetcode.com/problems/base-7/submissions/
 */
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        boolean isNeg = false;
        
        if (num < 0) {
            num = -num;
            isNeg = true;
        }
        
        while (num > 0) {
            result.append(num % 7);
            
            num /= 7;
        }
                
        if (isNeg) {
            result.append("-");
        }
        
        return result.reverse().toString();
    }
}