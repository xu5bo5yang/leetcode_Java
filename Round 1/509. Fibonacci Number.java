/**
 * https://leetcode.com/problems/fibonacci-number/submissions/
 */
class Solution {
    public int fib(int N) {
        if (N < 0) {
            return -1;
        }
        
        if (N < 2) {
            return N;
        }
        
        if (N == 2) {
            return 1;
        }
        
        int result = 0;
        int pre1 = 1;
        int pre2 = 1;
        
        for (int i = 3; i <= N; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        
        return result;
    }
}