/**
 * https://leetcode.com/problems/contains-duplicate-iii/submissions/
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        
        TreeSet<Long> numSet = new TreeSet();
        numSet.add(Long.valueOf(nums[0]));
        
        for (int i = 1; i < nums.length; i++) {
            if (i > k) {
                numSet.remove(Long.valueOf(nums[i-k-1]));
            }
            
            Long num = Long.valueOf(nums[i]);
            
            if (numSet.ceiling(num) != null && numSet.ceiling(num) <= num + t ||
               (numSet.floor(num) != null && numSet.floor(num) >= num - t)) {
                return true;
            }
            
            numSet.add(num);
        }
        
        return false;
    }
}