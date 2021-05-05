/**
 * https://leetcode.com/problems/rectangle-area/submissions/
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int intersectX = 0;
        int intersectY = 0;
        
        if (A >= G || E >= C) {
            intersectX = 0;
        } else if (B >= H || F >= D) {
            intersectY = 0;
        } else {
            intersectX = findInterSect(A, C, E, G);
            intersectY = findInterSect(B, D, F, H);
        }
        
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        return area1 + area2 - intersectX * intersectY;
    }
    
    int findInterSect(int l1, int r1, int l2, int r2) {
        return Math.min(r1, r2) - Math.max(l1, l2);
    }
}