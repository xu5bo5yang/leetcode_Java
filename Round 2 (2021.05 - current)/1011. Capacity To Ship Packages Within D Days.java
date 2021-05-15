class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int totalWeight = 0;
        
        for (int weight : weights) {
            if (weight > maxWeight) {
                maxWeight = weight;
            }
            
            totalWeight += weight;
        }
        
        int left = maxWeight;
        int right = totalWeight;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canShipAll(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canShipAll(int[] weights, int days, int load) {
        int curLoad = 0;
        int daysNeed = 1;
        
        for (int weight : weights) {
            if (curLoad + weight > load) {
                daysNeed++;
                curLoad = weight;
            } else {
                curLoad += weight;
            }
        }
        
        return daysNeed <= days;
    }
}