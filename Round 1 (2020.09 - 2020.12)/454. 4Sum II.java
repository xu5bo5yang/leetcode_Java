/**
 * https://leetcode.com/problems/4sum-ii/submissions/
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumCount = new HashMap();
        
        for(int a : A) {
            for(int b : B){
                int sum = a + b;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1); 
            }
        }
        
        int result = 0;
        
        for(int c : C) {
            for(int d : D){
                int sum = - (c + d);
                result += sumCount.getOrDefault(sum, 0);
            }
        }
        
        return result;
    }
}