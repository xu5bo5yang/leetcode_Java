/**
 * https://leetcode.com/problems/self-crossing/submissions/
 */
class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) {
            return false;
        }
        
        int len = x.length;        
        
        for(int i = 3; i < len; i++) {
            if (x[i-2] <= x[i] && x[i-1] <= x[i-3]) {
                return true;
            }
            
            if (i >= 4) {
                if(x[i-1] == x[i-3] && x[i-2] <= x[i] + x[i-4]) {
                    return true;
                }
            }
            
            if (i >= 5) {
                if (0 <= x[i-2] - x[i-4] && x[i-2] - x[i-4] <= x[i] && x[i-3] - x[i-5] <= x[i-1] && x[i-1] <= x[i-3]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}