/**
 * https://leetcode.com/problems/h-index-ii/submissions/
 */
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 1) {
            return 0;
        }
        
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= h) {
                break;
            }
            
            h++;
        }
        
        return h;
    }
}