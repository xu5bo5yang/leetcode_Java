/**
 * https://leetcode.com/problems/count-primes/submissions/
 */
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        
        int result = 0;
        boolean[] prime = new boolean[n];
        
        Arrays.fill(prime, true);
        
        for (int i = 2; i * i < n; i++) {
            if (!prime[i]) {
                continue;
            }
            
            for (int j = i * i; j < n; j += i) {
                prime[j] = false;
            }
        }
        
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                result++;
            }
        }
        
        return result;
    }
    
    boolean isPrime(int n) {     
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}