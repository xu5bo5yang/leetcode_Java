/**
 * https://leetcode.com/problems/redundant-connection/submissions/
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        
        for (int[] edge : edges) {
            int child = unionFind(parents, edge[0]);
            int parent = unionFind(parents, edge[1]);
            
            if (parent == child) {
                return edge;
            }
            
            parents[child] = parent;
        }
        
        return new int[0];
    }
    
    int unionFind(int[] parents, int node) {
        if (parents[node] == 0) {
            return node;
        }
        
        parents[node] = unionFind(parents, parents[node]);
        
        return parents[node];
    }
}