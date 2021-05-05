/**
 * https://leetcode.com/problems/longest-consecutive-sequence/submissions/
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet();
        
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longest = 0;
        
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int cur = 1;
                num++;
                
                while (numSet.contains(num)) {
                    num++;
                    cur++;
                }
                
                longest = Math.max(longest, cur);
            }
        }
        
        return longest;
    }
}