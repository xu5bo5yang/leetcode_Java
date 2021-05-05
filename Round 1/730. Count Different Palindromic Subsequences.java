/**
 * https://leetcode.com/problems/count-different-palindromic-subsequences/submissions/
 */
class Solution {
    
    private static long MOD = 1000000007;

    public int countPalindromicSubsequences(String S) {
        if (S == null || S.length() < 1) {
            return 0;
        }
        
        int len = S.length();
        int[][] dp = new int[len][len];


        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        
        for(int i = 1; i < len; i++){
            for(int left = 0, right = i; right < len; left++, right++){
                if(S.charAt(left) == S.charAt(right)){
                    int leftIdx = left + 1;
                    int rightIdx = right - 1;
                    char c = S.charAt(left);
                    
                    dp[left][right] = 2 * dp[left + 1][right - 1];

                    while(leftIdx <= rightIdx && c != S.charAt(leftIdx)){
                        leftIdx++;
                    }
                    
                    while(leftIdx <= rightIdx && c != S.charAt(rightIdx)){
                        rightIdx--;
                    }
                    
                    if (leftIdx > rightIdx) {
                        dp[left][right] += 2;
                    } else if (leftIdx == rightIdx) {
                        dp[left][right] += 1;
                    } else {
                        dp[left][right] -= dp[leftIdx + 1][rightIdx - 1];
                    }
                } else {
                    dp[left][right] = dp[left][right - 1] + dp[left + 1][right] - dp[left + 1][right - 1];
                }

                dp[left][right] = (int) ((dp[left][right] + MOD) % MOD);
            }
        }
        
        return dp[0][len - 1];
    }
}