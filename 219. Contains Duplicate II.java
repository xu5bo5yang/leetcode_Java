/**
 * 
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }
        
        Map<Integer, Integer> indexMap = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int prev = indexMap.get(nums[i]);
                
                if (i - prev <= k) {
                    return true;
                }
            }
            
            indexMap.put(nums[i], i);
        }
        
        return false;
    }
}