/**
 * https://leetcode.com/problems/sqrtx/submissions/
 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        return findSqrt(1, x, x);
    }
    
    int findSqrt(int low, int high, int x) {
        if (high - low <= 1) {
            return low;
        }
        
        int mid = low + (high - low) / 2;
        
        if (x / mid == mid) {
            return mid;
        } else if (x / mid < mid) {
            return findSqrt(low, mid, x);
        } else {
            return findSqrt(mid, high, x);
        }
    }
}