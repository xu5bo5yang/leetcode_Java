/**
 * https://leetcode.com/problems/number-complement/submissions/
 */
class Solution {
    public int findComplement(int num) {
        int comp = 0;
        
        while (comp < num) {
            comp = (comp << 1) | 1;
        }
        
        return comp - num;
    }
}