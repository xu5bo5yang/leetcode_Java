/**
 * https://leetcode.com/problems/assign-cookies/submissions/
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length < 1 || s.length < 1) {
            return 0;
        }
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;
        
        for (int cookie = 0; child < g.length && cookie < s.length; cookie++) {
            if (g[child] <= s[cookie]) {
                child++;
            }
        }
        
        return child;
    }
}