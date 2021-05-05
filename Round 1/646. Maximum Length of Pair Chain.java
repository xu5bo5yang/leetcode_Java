/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/submissions/
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length < 1) {
            return 0;
        }
        
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        int result = 0;
        int i = 0;
        
        while (i < pairs.length) {
            result++;
            
            int right = pairs[i][1];
            
            while (i < pairs.length && pairs[i][0] <= right) {
                i++;
            }
        }
        
        return result;
    }
}