/**
 * https://leetcode.com/problems/reaching-points/submissions/
 */
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        
        if ((sx == tx && (ty - sy) % sx == 0) || 
           (sy == ty && (tx - sx) % sy == 0)) {
            return true;
        }
        
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}