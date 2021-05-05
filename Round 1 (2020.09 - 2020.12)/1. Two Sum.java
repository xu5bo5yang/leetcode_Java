/**
 *  8:26 PM 9/1/2020https://leetcode.com/problems/two-sum/submissions/
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberHashTable = new HashMap<Integer, Integer>();
        
        for (int i=0; i < nums.length; i++) {
            int expected = target - nums[i];
            
            if (numberHashTable.containsKey(expected)) {
                return new int[] {numberHashTable.get(expected), i};
            }
            
            numberHashTable.put(nums[i], i);
        }
                
        throw new IllegalArgumentException("No solution found!");
    }
}