/**
 * https://leetcode.com/problems/arranging-coins/submissions/
 */
class Solution {
    public int arrangeCoins(int n) {
        if (n < 1) {
            return 0;
        }
        
        return (int) findK(n, 1, n);
    }
    
    long findK(long target, long low, long high) {
        if (high * (high + 1) / 2 == target) {
            return low;
        }
        
        if (low + 1 == high) {
            return low;
        }
        
        long mid = low + (high - low) / 2;
        
        if (mid * (mid + 1) / 2 == target) {
            return mid;
        } else if (mid * (mid + 1) / 2 < target) {
            return findK(target, mid, high);
        } else {
            return findK(target, low, mid);
        }
    }
}