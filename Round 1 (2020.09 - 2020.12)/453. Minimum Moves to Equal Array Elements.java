/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/submissions/
 */
class Solution {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        
        // sum + count * (n - 1) = (min + count) * n
        return sum - min * len;
    }
}