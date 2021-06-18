class Solution {
    
    private int[][] memo;
    
    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        
        for (int[] line : memo) {
            Arrays.fill(line, -1);
        }
        
        return dp(k, n);
    }
    
    private int dp(int k, int n) {  
        if (n == 0 || n == 1) {
            return n;
        }
        
        if (k == 1) {
            return n;
        }
        
        if (memo[k][n] != -1) {
            return memo[k][n];
        }
        
        int result = n;
        int low = 1;
        int high = n;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int l = dp(k - 1, mid - 1);
            int r = dp(k, n - mid);

            if (l < r) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            
            result = Math.min(result, Math.max(l, r) + 1);
        }

        memo[k][n] = result;
        return result;
    }
}
