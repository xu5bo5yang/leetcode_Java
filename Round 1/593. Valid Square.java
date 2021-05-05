/**
 * https://leetcode.com/problems/valid-square/submissions/
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = getDistance(p1, p2);
        if (d12 == 0 || d12 != getDistance(p3, p4)) {
            return false;
        }
        
        int d13 = getDistance(p1, p3);
        if (d13 == 0 || d13 != getDistance(p2, p4)) {
            return false;
        }
        
        int d14 = getDistance(p1, p4);
        if (d14 == 0 || d14 != getDistance(p2, p3)) {
            return false;
        }
        
        if (d12 == d13 || d12 == d14 || d13 == d14) {
            return true;
        }
        
        return false;
    }
    
    int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}