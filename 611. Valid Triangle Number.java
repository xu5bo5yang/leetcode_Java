/**
 * https://leetcode.com/problems/valid-triangle-number/submissions/
 */
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int count = 0;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            
            int k = i + 2;
            
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                
                count += k - j - 1;
            }
        }
        
        return count;
    }
}