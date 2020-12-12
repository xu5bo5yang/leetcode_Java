/**
 * https://leetcode.com/problems/bulb-switcher-ii/submissions/
 */
class Solution {
    public int flipLights(int n, int m) {
        if (n == 1 && m > 0) {
            return 2;
        }
        
        if (n == 2 && m == 1) {
            return 3;
        } 
        
        if ((n > 2 && m == 1) || (n == 2 && m > 1)) {
            return 4;
        }
    
        if (n > 2 && m == 2) {
            return 7;
        }
        
        if (n > 2 && m > 2) {
            return 8;
        } 
                
        return 1;
    }
}