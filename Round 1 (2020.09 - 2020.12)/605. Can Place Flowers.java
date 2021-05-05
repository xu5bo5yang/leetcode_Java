/**
 * https://leetcode.com/problems/can-place-flowers/submissions/
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n < 1) {
            return true;
        }
        
        if (flowerbed == null || flowerbed.length < n) {
            return false;
        }
        
        int count = 0;
        
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
               (i == 0 || flowerbed[i - 1] == 0) &&
               (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
                i++;
            }
            
            if (count >= n) {
                return true;
            }
        }
        
        return false;
    }
}