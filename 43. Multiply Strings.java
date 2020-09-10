/**
 * https://leetcode.com/problems/multiply-strings/submissions/
 */
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        int[] nums = new int[num1.length() + num2.length()];
        
        for(int i = 0; i < num1.length(); i++) {
            for(int j = 0; j < num2.length(); j++) {
                nums[i+j] += (num1.charAt(num1.length()-1-i)-'0') * (num2.charAt(num2.length()-1-j)-'0');
            }
        }
        
        int carry = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = nums[i] + carry;
            nums[i] = sum % 10;
            carry = sum/10;
        }
        
        StringBuilder result = new StringBuilder();
        if (nums[nums.length-1] != 0) {
            result.append(nums[nums.length-1]);
        }
        
        for(int i = nums.length - 2; i >= 0; i--) {
            result.append(nums[i]);
        }
        
        return result.toString();
    }
}