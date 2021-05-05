/**
 * https://leetcode.com/problems/power-of-four/
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((Integer.toBinaryString(num).length() - 1) % 2 == 0);
    }
}