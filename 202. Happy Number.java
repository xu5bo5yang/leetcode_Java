/**
 * https://leetcode.com/problems/happy-number/submissions/
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet();
        
        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            
            visited.add(n);
            n = calculateNextInt(n);
        }
        
        return true;
    }
    
    int calculateNextInt(int n) {
        int result = 0;
        
        while (n > 0) {
            result += Math.pow(n % 10, 2);
            n = n / 10;
        }

        return result;
    }
}