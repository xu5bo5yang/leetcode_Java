/**
 * https://leetcode.com/problems/valid-perfect-square/
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        
        int low = 2;
        int high = num / 2;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int div = num / mid;
            
            if (div == mid && num % mid == 0) {
                return true;
            }
            
            if (div > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}