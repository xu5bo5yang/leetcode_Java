/**
 * https://leetcode.com/problems/h-index/submissions/
 */
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 1) {
            return 0;
        }
        
        int len = citations.length;
        int[] h = new int[len+1];
        
        for (int i = 0; i < len; i++) {
            if (citations[i] > len) {
                h[len]++;
            } else {
                h[citations[i]]++;
            }
        }
        
        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += h[i];
            
            if (total >= i) {
                return i;
            }
        }
        
        return 0;
    }
}