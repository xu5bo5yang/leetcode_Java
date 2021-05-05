/**
 * https://leetcode.com/problems/pyramid-transition-matrix/submissions/
 */
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Set<Character>[][] allowedChars = new Set[7][7];

        for (String triple : allowed) {
            int i = triple.charAt(0) - 'A';
            int j = triple.charAt(1) - 'A';
            
            if (allowedChars[i][j] == null) {
                allowedChars[i][j] = new HashSet();
            }

            allowedChars[i][j].add(triple.charAt(2));
        }

        return dfs(allowedChars, bottom, "", 0);
    }
    
    boolean dfs(Set<Character>[][] allowedChars, String bottom, String top, int k) {
        if (bottom.length() == 1) {
            return true;
        }

        if (k == bottom.length() - 1) {
            return dfs(allowedChars, top, "", 0);
        }

        int i = bottom.charAt(k) - 'A';
        int j = bottom.charAt(k + 1) - 'A';
        
        if (allowedChars[i][j] == null) {
            return false;
        }

        for (char candidate : allowedChars[i][j]) {
            if (dfs(allowedChars, bottom, top + candidate, k + 1)) {
                return true;
            }
        }

        return false;
    }
}