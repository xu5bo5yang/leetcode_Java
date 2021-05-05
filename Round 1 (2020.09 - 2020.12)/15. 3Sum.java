/**
 * https://leetcode.com/problems/3sum/submissions/
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        
        int i = 0;
        while (i < nums.length) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;   
                } else {
                    List<Integer> solution = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(solution);
                    
                    int leftNum = nums[left];
                    while (nums[left] == leftNum && left < right) {
                        left++;
                    }
                    
                    int rightNum = nums[right];
                    while (nums[right] == rightNum && left < right) {
                        right--;
                    }
                }
            }
            
            int curNum = nums[i];
            while (i < nums.length && nums[i] == curNum) {
                i++;
            }
        }
        
        return new ArrayList<List<Integer>>(result);
    }
}