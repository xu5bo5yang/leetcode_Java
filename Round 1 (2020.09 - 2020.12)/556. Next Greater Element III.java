/**
 * https://leetcode.com/problems/next-greater-element-iii/submissions/
 */
class Solution {
    public int nextGreaterElement(int n) {
        if (n < 1) {
            return -1;
        }
        
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length - 2;
        
        while (i >= 0 && digits[i+1] <= digits[i]) {
            i--;
        }
        
        if (i < 0) {
            return -1;
        }
        
        int j = digits.length - 1;
        
        while (j >= i && digits[j] <= digits[i]) {
            j--;
        }
        
        swap(digits, i, j);
        reverse(digits, i + 1, digits.length - 1);
        
        try {
            return Integer.valueOf(String.valueOf(digits));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            
            left++;
            right--;
        }
    }
}