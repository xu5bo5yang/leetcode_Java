/**
 * https://leetcode.com/problems/self-dividing-numbers/submissions/
 */
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        if (right < left) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();
        
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    boolean isSelfDividing(int num) {
        int cur = num;
        
        while (cur != 0) {
            int digit = cur % 10;
            
            if (digit == 0 || num % digit > 0) {
                return false;
            }
            
            cur /= 10;
        }
        
        return true;
    }
}