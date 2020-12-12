/**
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/submissions/
 */
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            
            for (int i = 1, j = n; i <= m; i++) {
                while (j >= 1 && i * j > mid) {
                    j--;
                }
                
                count += j;
            }
            
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}