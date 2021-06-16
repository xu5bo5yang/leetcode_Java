class Solution {
    
    private int[][] memo;
    private Map<Character, Set<Integer>> charIndex;
    
    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        
        memo = new int[m][n];
        charIndex = new HashMap();
        
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            Set<Integer> indexes = charIndex.getOrDefault(c, new HashSet());
            
            indexes.add(i);
            charIndex.put(c, indexes);
        }
        
        return dp(ring, 0, key, 0);
    }
    
    int dp(String ring, int i, String key, int j) {
        if (j == key.length()) {
            return 0;
        }
        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int result = Integer.MAX_VALUE;
        
        for (int k : charIndex.get(key.charAt(j))) {
            int subProblem = dp(ring, k, key, j + 1);
            int d = Math.abs(k - i);
            
            d = Math.min(d, ring.length() - d); 
            result = Math.min(result, 1 + d + subProblem);
        }
        
        memo[i][j] = result;
        
        return result;
    }
}