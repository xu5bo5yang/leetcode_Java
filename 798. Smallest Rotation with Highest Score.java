/**
 * https://leetcode.com/problems/smallest-rotation-with-highest-score/submissions/
 */
class Solution {
    public int bestRotation(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }
        
        int[] rotateLoss = new int[A.length];
        int[] score = new int[A.length];
        int max = score[0];
        int result = 0;
        
        for (int i = 0; i < A.length; i++) {
            rotateLoss[(i - A[i] + A.length + 1) % A.length] += 1;
        }
        
        for (int i = 1; i < A.length; i++) {
            score[i] = score[i - 1] - rotateLoss[i] + 1;
            
            if (score[i] > max) {
                max = score[i];
                result = i;
            }
        }
        
        return result;
    }
}