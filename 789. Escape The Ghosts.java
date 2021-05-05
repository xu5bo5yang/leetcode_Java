/**
 * https://leetcode.com/problems/escape-the-ghosts/submissions/
 */
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int movesNeeded = Math.abs(target[0]) + Math.abs(target[1]);
        
        for (int[] ghost : ghosts) {
            int movesToCatch = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            
            if (movesToCatch <= movesNeeded) {
                return false;
            }
        }
        
        return true;
    }
}