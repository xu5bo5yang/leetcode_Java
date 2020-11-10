/**
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/submissions/
 */
class Solution {
    public int findKthNumber(int n, int k) {
        int result = 1;
        
        while (k > 1) {
            int count = findKth(n , result, result + 1);
            
            if (count < k) {
                result++;
                k -= count;
            } else {
                result *= 10;
                k--;
            }
        }
        
        return result;
    }
    
    int findKth(long n, long p, long q) {
        int result = 0;
        
        while (p <= n) {
            result += Math.min(q, n + 1) - p;
            
            p *= 10;
            q *= 10;
        }
        
        return result;
    }
}