/**
 * https://leetcode.com/problems/delete-and-earn/submissions/
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> numSum = new HashMap();
        
        for (int num : nums) {
            numSum.put(num, numSum.getOrDefault(num, 0) + num);
        }
        
        int prev = 0;
        int total = 0;
        
        for (int num : numSum.keySet()) {
            if (numSum.containsKey(num - 1)) {
                int tmp = total;
                total = Math.max(total, prev + numSum.get(num));
                prev = tmp;
            } else {
                prev = total;
                total += numSum.get(num);
            }
        }
        
        return total;
    }
}