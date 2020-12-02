/**
 * https://leetcode.com/problems/range-addition-ii/submissions/
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        
        if (minRow == Integer.MAX_VALUE) {
            return minCol == Integer.MAX_VALUE ? m * n : minCol;
        } else {
            return minCol == Integer.MAX_VALUE ? minRow : minRow * minCol;
        }
    }
}