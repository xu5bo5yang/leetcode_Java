/**
 * https://leetcode.com/problems/heaters/submissions/
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || heaters == null || houses.length < 1 || heaters.length < 1) {
            return 0;
        }
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int result = 0;
        int i = 0;
        
        for (int house : houses) {
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            
            result = Math.max(result, Math.abs(heaters[i] - house));
        }
        
        return result;
    }
}