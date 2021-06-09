class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        
        int pre = nums[0];
        int cur = 0;
        int result = pre;
        
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + pre);
            pre = cur;
            result = Math.max(result, cur);
        }
        
        return result;
    }
}