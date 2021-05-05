/**
 * https://leetcode.com/problems/redundant-connection-ii/submissions/
 */
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parents = new int[edges.length + 1];
        
        for (int[] edge : edges) {
            if (parents[edge[1]] == 0) {
                parents[edge[1]] = edge[0];
            } else {
                can2 = new int[]{edge[0], edge[1]};
                can1 = new int[]{parents[edge[1]], edge[1]};
                edge[1] = 0;
            }
        }
        
        for (int i = 0; i < edges.length; i++) {
            parents[i] = i;
        }
        
        for (int[] edge : edges) {
            if (edge[1] == 0) {
                continue;
            }
            
            int child = edge[1];
            int parent = edge[0];
        
            if (unionFind(parents, parent) == child) {
                if (can1[0] == -1) {
                    return edge;
                }
                
                return can1;
            }
            
            parents[child] = parent;
        }
        
        return can2;
    }
    
    int unionFind(int[] parents, int node) {
        while (node != parents[node]) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        
        return node;
    }
}