/**
 * https://leetcode.com/problems/random-pick-index/submissions/
 */
class Solution {
    
    Map<Integer, List<Integer>> numIndex;

    public Solution(int[] nums) {
        numIndex = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            if (!numIndex.containsKey(nums[i])) {
                numIndex.put(nums[i], new ArrayList());
            }
            
            numIndex.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = numIndex.get(target);
        
        if (indices.isEmpty()) {
            return -1;
        } else if (indices.size() == 1) {
            return indices.get(0);
        } else {
            Random random = new Random();
            
            return indices.get(random.nextInt(indices.size()));
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */