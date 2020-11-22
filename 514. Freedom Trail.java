/**
 * https://leetcode.com/problems/freedom-trail/submissions/
 */
class Solution {
    public int findRotateSteps(String ring, String key) {
        char[] ringArr = ring.toCharArray();
        char[] keyArr = key.toCharArray();
        
        return dfs(ringArr, keyArr, 0, 0, new int[ringArr.length][keyArr.length]);
    }
    
    int dfs(char[] ring, char[] target, int targetIndex, int ringIndex, int[][] memo){
        if(targetIndex == target.length) {
            return 0;
        }
        
        if(memo[ringIndex][targetIndex] != 0) {
            return memo[ringIndex][targetIndex];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0;i < ring.length; i++){
            if(ring[i] != target[targetIndex])  {
                continue;
            }
            
            int dif = Math.abs(i - ringIndex);
            int distance = Math.min(dif, ring.length - dif) + dfs(ring, target, targetIndex + 1, i, memo) + 1;
            min = Math.min(min, distance);            
        }
        
        memo[ringIndex][targetIndex] = min;
        
        return min;
    }
}