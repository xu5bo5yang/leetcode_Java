/**
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/submissions/
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int result = 0;
        Map<Integer, Integer>[] diffMaps = new HashMap[A.length];
        
        for(int i = 0; i < A.length; i++) {
            diffMaps[i] = new HashMap();
            int num = A[i];
            
            for(int j = 0; j < i; j++) {
                if((long)num-A[j]>Integer.MAX_VALUE) {
                    continue;
                }
                
                if((long)num-A[j]<Integer.MIN_VALUE) {
                    continue;
                }
                
                int diff = num - A[j];
                int count = diffMaps[j].getOrDefault(diff, 0);
                
                result += count;
                
                diffMaps[i].put(diff, diffMaps[i].getOrDefault(diff,0) + count + 1);
            }
        }
        return result;
    }
}