/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/submissions/
 */
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        
        for (int i = L; i <= R; i++) {
            if (isPrime(Integer.bitCount(i))) {
                count++;
            }
        }
       
        return count;
    } 
    
    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        if (n < 4) {
            return true;
        }
        
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
}