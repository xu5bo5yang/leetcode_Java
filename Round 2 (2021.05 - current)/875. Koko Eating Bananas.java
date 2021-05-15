class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int getMax(int[] piles) {
        int max = 0;
        
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        
        return max;
    }
    
    private boolean canEatAll(int[] piles, int h, int k) {
        int totalTime = 0;
        
        for (int pile : piles) {
            totalTime += eatTime(pile, k);
        }
        
        return totalTime <= h;
    }
    
    private int eatTime(int pile, int k) {
        return pile / k + (pile % k > 0 ? 1 : 0);
    }
}
