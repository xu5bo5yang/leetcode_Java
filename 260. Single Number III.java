/**
 * https://leetcode.com/problems/single-number-iii/submissions/
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        
        Set<Integer> visited = new HashSet();
        
        for (int num : nums) {
            if (visited.contains(num)) {
                visited.remove(num);
            } else {
                visited.add(num);
            }
        }
        
        int[] result = new int[2];
        int i = 0;
        for (int num : visited) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
}