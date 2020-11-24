/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/submissions/
 */
class Solution {
    public int findLUSlength(String[] strs) {
        int result = -1;
        int len = strs.length;
        
        for (int i = 0; i < len; i++) {
            if (strs[i].length() < result) {
                continue;
            }
            
            int j = 0;
            
            while (j < len) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    break;
                }
                
                j++;
            }
            
            if (j == len) {
                result = Math.max(result, strs[i].length());
            }
        }
        
        return result;
    }
    
    boolean isSubsequence(String a, String b){
        int i = 0;
        int j = 0;
        
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            
            j++;
        }
        
        return i == a.length();
    }
}
