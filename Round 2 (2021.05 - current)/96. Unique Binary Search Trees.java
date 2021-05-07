class Solution {
    
    private int[][] results;
    
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }
        
        results = new int[n + 1][n + 1];
        
        return buildTrees(1, n);
    }
    
    private int buildTrees(int l, int r) {
        if (l > r) {
            return 1;
        }
        
        if (results[l][r] != 0) {
            return results[l][r];
        }
        
        int count = 0;
        
        for (int i = l; i <= r; i++) {
            int left = buildTrees(l, i - 1);
            int right = buildTrees(i + 1, r);
            
            count += left * right;
        }
        
        results[l][r] = count;
        return count;
    }
}