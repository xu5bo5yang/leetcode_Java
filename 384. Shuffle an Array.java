/** 
 * https://leetcode.com/problems/shuffle-an-array/submissions/
 */
class Solution {

    int[] original;
    
    public Solution(int[] nums) {
        original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = original.clone();
        Random random = new Random();
        int max = result.length;
        
        for (int i = 0; i < result.length; i++) {
            int rand = random.nextInt(max - i) + i;
            int tmp = result[rand];
            result[rand] = result[i];
            result[i] = tmp;
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */