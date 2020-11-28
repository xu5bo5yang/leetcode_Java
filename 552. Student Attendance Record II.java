/**
 * https://leetcode.com/problems/student-attendance-record-ii/submissions/
 */
class Solution {
    public int checkRecord(int n) {
        int mod = (int) (1e9+7);
        long[] P = new long[n + 1];
        long[] L = new long[n + 1];
        P[0] = 1;
        P[1] = 1;
        L[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            P[i] = (P[i-1] + L[i-1]) % mod;
            L[i] = (P[i-1] + P[i-2]) % mod;
        }
        
        long result = (P[n] + L[n]) % mod;
        //insert A 
        for (int i = 0; i < n; i++) { 
            long a = ((P[i] + L[i]) % mod * (P[n-i-1] + L[n-i-1]) %mod) % mod;
            
            result = (result + a) % mod;
        }
        
        return (int) result;
    }
}