/**
 * https://leetcode.com/problems/circular-array-loop/submissions/
 */
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            
            int slow = i;
            int fast = getNextIndex(i, nums);
            
            while (nums[fast] * nums[i] > 0 && nums[getNextIndex(fast, nums)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == getNextIndex(slow, nums)) {
                        break;
                    }
                    
                    return true;
                }
                
                slow = getNextIndex(slow, nums);
                fast = getNextIndex(getNextIndex(fast, nums), nums);
            }
            
            slow = i;
            
            while (nums[slow] * nums[i] > 0) {
                nums[slow] = 0;
                slow = getNextIndex(slow, nums);
            }
        }
        
        return false;
    }
    
    int getNextIndex(int i, int[] nums) {
        int len = nums.length;
        
        return i + nums[i] >= 0? (i + nums[i]) % len: (len + ((i + nums[i]) % len)) % len;
    }
}