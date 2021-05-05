/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/submissions/
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList();
        
        dfs(result, new ArrayList(), graph, 0);
        
        return result;
    }
    
    void dfs(List<List<Integer>> result, List<Integer> prev, int[][] graph, int source) {
        prev.add(source);
        
        if (source == graph.length - 1) {
            result.add(prev);
        }
        
        for (int target : graph[source]) {
            List<Integer> tmp = new ArrayList(prev);
            
            dfs(result, tmp, graph, target);
        }
    }
}