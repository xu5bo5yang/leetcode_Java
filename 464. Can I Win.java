/**
 * https://leetcode.com/problems/can-i-win/submissions/
 */
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        
        return canWin(new HashMap(), maxChoosableInteger, desiredTotal, 0);
    }
    
    boolean canWin(Map<Integer, Boolean> canWinMap, int maxChoosableInteger, int desiredTotal, int state) {
        if (desiredTotal < 1) {
            return false;
        }
        
        if (canWinMap.containsKey(state)) {
            return canWinMap.get(state);
        }
        
        boolean result = false;
        
        for (int i = 0; i < maxChoosableInteger; i++) {
            if ((1 << i & state) == 0) {
                if (!canWin(canWinMap, maxChoosableInteger, desiredTotal - i - 1, 1 << i | state)) {
                    result = true;
                    break;
                }
            }
        }
        
        canWinMap.put(state, result);
        
        return result;
    }
}