/**
 * https://leetcode.com/problems/matchsticks-to-square/submissions/
 */
class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4) {
            return false;
        }
        
        int sum = 0;
        
        for(int num : nums){
            sum += num;
        }
        
        if(sum % 4 != 0) {
            return false;
        }
        
        Arrays.sort(nums);

        int width = sum / 4;
        int edge1 = 0;
        int edge2 = 0;
        int edge3 = 0;
        int edge4 = 0;
        
        return canAddStick(nums, nums.length - 1, edge1, edge2, edge3, edge4, width);
    }
    
    boolean canAddStick(int[] nums, int stickIndex, int edge1, int edge2, int edge3, int edge4, int width){
        if(width < edge1 || width < edge2 || width < edge3 || width < edge4) {
            return false;
        }
        
        if(stickIndex == -1){
            if(edge1 == width && edge2 == width && edge3 == width && edge4 == width) {
                return true;
            } else {
                return false;
            }
        }

        return canAddStick(nums, stickIndex - 1, edge1 + nums[stickIndex], edge2, edge3, edge4, width) || 
            canAddStick(nums, stickIndex - 1, edge1, edge2 + nums[stickIndex], edge3, edge4, width) || 
            canAddStick(nums, stickIndex - 1, edge1, edge2, edge3 + nums[stickIndex], edge4, width) || 
            canAddStick(nums, stickIndex - 1, edge1, edge2, edge3,edge4 + nums[stickIndex], width);
    }
}