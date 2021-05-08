class Solution {
    
    private List<List<Integer>> result;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length < 1) {
            return new LinkedList();
        }
        
        result = new LinkedList();
        traverse(graph, 0, new LinkedList());
        
        return result;
    }
    
    private void traverse(int[][] graph, int node, LinkedList<Integer> path) {
        path.addLast(node);
        
        if (node == graph.length - 1) {
            result.add(new LinkedList(path));
        } else {
            for (int neighbor : graph[node]) {
                traverse(graph, neighbor, path);
            }
        }
        
        path.removeLast();
    }
}
