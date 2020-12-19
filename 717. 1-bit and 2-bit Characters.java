/**
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/submissions/
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length < 1) {
            return false;
        }
        
        int index = 0;
        
        while (index < bits.length - 1) {
            if (bits[index] == 1) {
                index += 2;
            } else {
                index++;
            }
        }
        
        return index == bits.length - 1;
    }
}