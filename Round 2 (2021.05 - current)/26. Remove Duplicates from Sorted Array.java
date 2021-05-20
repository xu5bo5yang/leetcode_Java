class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        int slow = 0;
        int fast = 0;
        
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast++;
                continue;
            }
            
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
        
        return slow + 1;
    }
}