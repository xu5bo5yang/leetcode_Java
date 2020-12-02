/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/submissions/
 */
class Solution {
    public String fractionAddition(String expression) {
        Scanner scanner = new Scanner(expression).useDelimiter("/|(?=[-+])");
        long dividend = 0;
        long divisor = 1;
        
        while (scanner.hasNext()) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            
            dividend = dividend * b + a * divisor;
            divisor *= b;
        }
        
        long gcd = gcd(dividend, divisor);
        
        return (dividend / gcd) + "/" + (divisor / gcd);
    }
    
    long gcd(long a, long b) {
        if (b == 0) {
            return a < 0 ? -a : a;
        }
        
        return gcd(b, a % b);
    }
}