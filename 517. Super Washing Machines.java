/**
 * https://leetcode.com/problems/super-washing-machines/submissions/
 */
class Solution {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length < 1) {
            return 0;
        }
        
        int total = 0; 
        
        for (int dresses: machines) {
            total += dresses;
        }
        
        if (total % machines.length != 0) {
            return -1;
        }
        
        int avg = total / machines.length;
        int count = 0;
        int max = 0;
        
        for(int dresses: machines){
            count += dresses - avg;
            max = Math.max(Math.max(max, Math.abs(count)), dresses - avg);
        }
        
        return max;
    }
}