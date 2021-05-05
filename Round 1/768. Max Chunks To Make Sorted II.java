/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/submissions/
 */
class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        
        int len = arr.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];
        int result = 0;
        
        leftMax[0] = arr[0];
        rightMin[len - 1] = arr[len - 1];

        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        for (int i = 0; i < len - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                result++;
            }
        }

        return result + 1;
    }
}