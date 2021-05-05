/**
 * https://leetcode.com/problems/remove-element/submissions/
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int cur = 0;
        int result = 0;
        while (cur < nums.length) {
            if (nums[cur] != val) {
                nums[result] = nums[cur];
                cur++;
                result++;
            } else {
                int i = cur + 1;
                while (i < nums.length) {
                    if (nums[i] == val) {
                        i++;
                    } else {
                        nums[result] = nums[i];
                        result++;
                        cur = i + 1;
                        break;
                    }
                }
                
                if (i == nums.length) {
                    break;
                }
            }
        }
        
        return result;
    }
}