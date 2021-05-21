class Solution {
    public int fib(int N) {
        if (N < 1) {
            return 0;
        }
        
        if (N == 1) {
            return 1;
        }
        
        int pre = 0;
        int cur = 1;
        
        for (int i = 2; i <= N; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        
        return cur;
    }
}