/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted/submissions/
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        
        int result = 0;
        int max = 0;
        
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            
            if (max == i) {
                result++;
            }
        }
        
        return result;
    }
}