/**
 * https://leetcode.com/problems/hamming-distance/submissions/
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int xor = x ^ y;
        
        while (xor > 0){
            if (xor % 2 == 1) {
                result++;
            }
            
            xor /= 2;
        }
        
        return result;
    }
}