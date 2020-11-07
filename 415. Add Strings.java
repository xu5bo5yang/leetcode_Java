/**
 * https://leetcode.com/problems/add-strings/submissions/
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return "0";
        } else if (num1 == null) {
            return num2;
        } else if (num2 == null) {
            return num1;
        }
        
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i;
        int j;
        
        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int sum = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
                        
            carry = sum / 10;
            result.insert(0, String.valueOf(sum % 10));
        }
        
        if (j >= 0) {
            i = j;
            num1 = num2;
        }
        
        while (i >= 0) {
            int sum = (num1.charAt(i) - '0') + carry;
                        
            carry = sum / 10;
            result.insert(0, String.valueOf(sum % 10));
            i--;
        }
        
        if (carry == 1) {
            result.insert(0, "1");
        }
                
        return result.toString();
    }
}