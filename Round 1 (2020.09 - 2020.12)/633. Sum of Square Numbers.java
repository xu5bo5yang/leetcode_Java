/**
 * https://leetcode.com/problems/sum-of-square-numbers/submissions/
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        
        int left = 0;
        int right = (int) Math.sqrt(c);
        
        while (left <= right) {
            int sum = left * left + right * right;
            
            if (sum < c) {
                left++;
            } else if (sum > c) {
                right--;
            } else {
                return true;
            }
        }
        
        return false;
    }
}