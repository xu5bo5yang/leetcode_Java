/**
 * https://leetcode.com/problems/add-binary/submissions/
 */
class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 && j >= 0) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(j) - '0';
            int digit = digitA ^ digitB ^ carry;
            carry = (digitA + digitB + carry) > 1 ? 1 : 0;
            
            result = String.valueOf(digit) + result;
            
            i--;
            j--;
        }
        
        if (i < 0) {
            i = j;
            a = b;
        }
        
        while (i >= 0) {
            int digitA = a.charAt(i) - '0';
            int digit = digitA ^ carry;
            carry = (digitA + carry) > 1 ? 1 : 0;
            
            result = String.valueOf(digit) + result;
            
            i--;
        }
        
        if (carry == 1) {
            result = "1" + result;
        }
        
        return result;
    }
}