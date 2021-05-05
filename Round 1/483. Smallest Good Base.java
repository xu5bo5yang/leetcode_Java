/**
 * https://leetcode.com/problems/smallest-good-base/submissions/
 */
class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        
        for (int m = (int)(Math.log(num + 1) / Math.log(2)); m > 2; m--) {
            long left = (long)(Math.pow(num + 1, 1.0 / m));
            long right = (long)(Math.pow(num, 1.0 / (m - 1)));

            while (left <= right) {
                long key = left + (right - left) / 2;
                long f = 0L;
                
                for (int i = 0; i < m; i++) {
                     f = f * key + 1;
                }

                if (num == f) {
                    return String.valueOf(key);
                } else if (num < f) {
                    right = key - 1;
                } else {
                    left = key + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}