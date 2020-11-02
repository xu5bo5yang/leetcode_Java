/**
 * https://leetcode.com/problems/elimination-game/submissions/
 */
class Solution {
    public int lastRemaining(int n) {
        boolean goingLeft = true;
        int numsLeft = n;
        int step = 1;
        int cur = 1;
        
        while (numsLeft > 1) {
            if (goingLeft || numsLeft % 2 ==1) {
                cur = cur + step;
            }
            
            numsLeft = numsLeft / 2;
            step *= 2;
            goingLeft = !goingLeft;
        }
        
        return cur;
    }
}