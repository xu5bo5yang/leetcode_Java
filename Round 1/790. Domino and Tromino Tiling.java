/**
 * https://leetcode.com/problems/domino-and-tromino-tiling/submissions/
 */
class Solution {
    public int numTilings(int N) {
        int mod = 1000000007;
        int dp1 = 0;
        int dp2 = 1;
        int dp3 = 1;
        int cur = 0;
        
        while (N > 1) {
            cur = (dp3 * 2 % mod + dp1) % mod;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = cur;
            
            N--;
        }
        
        return dp3;
    }
}