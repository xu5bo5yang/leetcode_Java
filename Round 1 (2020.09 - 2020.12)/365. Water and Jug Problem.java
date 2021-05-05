/**
 * https://leetcode.com/problems/water-and-jug-problem/submissions/
 */
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        
        if (x == z || y == z || x + y == z) {
            return true;
        }
        
        int gcd = findGCD(x, y);
        
        return z % gcd == 0;
    }
    
    int findGCD(int x, int y) {
        while(y != 0 ) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        
        return x;
    }
}