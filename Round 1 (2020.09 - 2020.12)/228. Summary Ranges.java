/**
 * https://leetcode.com/problems/summary-ranges/submissions/
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        
        if (nums == null || nums.length < 1) {
            return result;
        }
        
        int i = 0;
        boolean hasRange = false;
        while (i < nums.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(nums[i]));
            
            
            while (i < nums.length - 1 && nums[i] + 1 == nums[i+1]) {
                i++;
                hasRange = true;
            }
            
            if (hasRange) {
                sb.append("->");
                sb.append(nums[i]);
                hasRange = false;
            }
            
            result.add(sb.toString());
            i++;
        }
        
        return result;
    }
}