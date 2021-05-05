/**
 * https://leetcode.com/problems/find-the-duplicate-number/solution/
 */
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        
        int n = nums.length - 1;
        int[] visited = new int[n + 1];
        
        for (int num : nums) {
            if (visited[num] != 0) {
                return num;
            }
            
            visited[num] = 1;
        }
        
        return 0;
    }
}