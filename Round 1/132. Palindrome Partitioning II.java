/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/submissions/
 */
class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] cuts = new int[len];
        int left;
        int right;
        
        for (int i = 0; i < len; i++) {
            cuts[i] = i;
        }
        
        for (int mid = 1; mid < len; mid++) {
            left = mid;
            right = mid;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                int newCutAtRight = (left == 0) ? 0 : cuts[left - 1] + 1;
                cuts[right] = Math.min(cuts[right], newCutAtRight);
                
                left--;
                right++;
            }
            
            left = mid - 1;
            right = mid;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                int newCutAtRight = (left == 0) ? 0 : cuts[left - 1] + 1;
                cuts[right] = Math.min(cuts[right], newCutAtRight);
                
                left--;
                right++;
            }
        }
        
        return cuts[len - 1];
    }
}