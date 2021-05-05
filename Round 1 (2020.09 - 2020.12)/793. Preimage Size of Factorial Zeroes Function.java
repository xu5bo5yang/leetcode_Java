/**
 * https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/submissions/
 */
class Solution {
    public int preimageSizeFZF(int K) {
        return binarySearch(K) - binarySearch(K - 1);
    }
    
    int binarySearch(int K) {
        int left = 0;
        int right =  5 * (K + 1);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int k = trailingZeros(mid);

            if (k <= K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
    
    int trailingZeros(int x) {
        int result = 0;

        while (x > 0) {
            result += x / 5;
            x /= 5;
        }

        return result;
    }
}