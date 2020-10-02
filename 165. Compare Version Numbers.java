/**
 * https://leetcode.com/problems/compare-version-numbers/submissions/
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) {
            return 0;
        } else if (version1 == null) {
            return -1;
        } else if (version2 == null) {
            return 1;
        }
        
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int len = Math.max(v1s.length, v2s.length);
        
        for (int i = 0; i < len; i++) {
            int v1 = i < v1s.length ? Integer.parseInt(v1s[i]) : 0;
            int v2 = i < v2s.length ? Integer.parseInt(v2s[i]) : 0;
            
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        
        return 0;
    }
}