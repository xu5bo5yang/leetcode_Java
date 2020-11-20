/**
 * https://leetcode.com/problems/reverse-pairs/submissions/
 */
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    int mergeSort(int[] nums, int left, int right){
        if(right <= left) {
            return 0; 
        }
        
        int mid = left + (right - left) / 2; 
        int result = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right); 
        
        for(int i = left, j = mid + 1; i <= mid; i++){
            while(j <= right && nums[j] < nums[i] / 2.0) {
                j++; 
            }
            
            result += j - mid - 1; 
        }
        
        Arrays.sort(nums, left, right + 1); 
        
        return result; 
    }
}