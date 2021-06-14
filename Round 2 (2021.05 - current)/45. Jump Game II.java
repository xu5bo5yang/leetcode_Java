class Solution {
    public int jump(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        
        int farthest = 0;
        int end = 0;
        int jump = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            if (end == i) {
                jump++;
                end = farthest;
            }
        }
        
        return jump;
    }
}