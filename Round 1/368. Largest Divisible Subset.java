/**
 * https://leetcode.com/problems/largest-divisible-subset/submissions/
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new ArrayList();
        }
        
        int len = nums.length;
        int[] count = new int[len];
        int[] pre = new int[len];
        
        Arrays.sort(nums);
        
        int index = -1;
        int max = 0;
        
        for (int i = 0; i < len; i++) {
            count[i] = 1;
            pre[i] = -1;
            
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            
            if (max < count[i]) {
                max = count[i];
                index = i;
            }
        }
        
        List<Integer> result = new ArrayList();
        while (index != -1) {
            result.add(nums[index]);
            index = pre[index];
        }
        
        return result;
    }
}