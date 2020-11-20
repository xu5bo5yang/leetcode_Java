/**
 * https://leetcode.com/problems/relative-ranks/submissions/
 */
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new String[0];
        }
        
        String[] result = new String[nums.length];
        Integer[] index = new Integer[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }
}