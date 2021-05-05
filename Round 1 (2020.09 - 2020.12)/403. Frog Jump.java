/**
 * https://leetcode.com/problems/frog-jump/submissions/
 */
class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length < 1) {
            return true;
        }
        
        int len = stones.length;
        boolean[][] canReach = new boolean[len][len + 1];
        canReach[0][1] = true;
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int distance = stones[i] - stones[j];
                
                if (distance < 0 || distance > len || !canReach[j][distance]) {
                    continue;
                }
                
                canReach[i][distance] = true;
                
                if (1 <= distance) {
                    canReach[i][distance - 1] = true;
                }
                
                if (distance < len) {
                    canReach[i][distance + 1] = true;
                }
                
                if (i == len - 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
}