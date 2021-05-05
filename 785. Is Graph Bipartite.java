/**
 * https://leetcode.com/problems/is-graph-bipartite/submissions/
 */
class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length < 1) {
            return false;
        }
        
        int[] visited = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList();
            
            queue.offer(i);
            visited[i] = 1;
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                
                for (int next : graph[cur]) {
                    if (visited[next] == 0) {
                        visited[next] = -visited[cur];
                        queue.offer(next);
                    } else if (visited[next] != -visited[cur]) {
                        return false;
                    }
                }
            }                        
        }
        
        return true;
    }
}