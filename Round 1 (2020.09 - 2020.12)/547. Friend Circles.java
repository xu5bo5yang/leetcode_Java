/**
 * https://leetcode.com/problems/friend-circles/submissions/
 */
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length < 1 || M[0].length < 1) {
            return 0;
        }
        
        int len = M.length;
        int result = 0;
        int[] root = new int[len]; 
        
        for (int i = 0; i < len; i++) {
            root[i] = i; 
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (M[i][j] == 1) {
                    unionFind(root, i, j);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (i == root[i]) {
                result++;
            }
        }
        
        return result;
    }
    
    void unionFind(int[] root, int v1, int v2) {
        while (root[v1] != v1) {
            v1 = root[v1];
        }
        
        while (root[v2] != v2) {
            v2 = root[v2];
        }
        
        if (root[v1] != root[v2]) {
            root[v2] = v1;
        }
    }
}