/**
 * https://leetcode.com/problems/4sum/submissions/
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        Arrays.sort(nums);
        
        int currentSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                
                while (left < right) {
                    currentSum = nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (currentSum == target) {
                        List<Integer> solution = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(solution);
                        
                        int currentLeft = nums[left];
                        while (left < right && currentLeft == nums[left]) {
                            left++;
                        }
                        
                        int currentRight = nums[right];
                        while (left < right && currentRight == nums[right]) {
                            right--;
                        }
                    } else if (currentSum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        
        return new ArrayList<List<Integer>>(result);
    }
}