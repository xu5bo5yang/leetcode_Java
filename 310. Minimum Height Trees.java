/**
 * https://leetcode.com/problems/minimum-height-trees/submissions/
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            return Arrays.asList(0);
        }
        
        Map<Integer, List<Integer>> nodeToNodes = new HashMap<>(); 
        Queue<Integer> queue = new LinkedList<>();
            
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            List<Integer> aNodes = nodeToNodes.getOrDefault(a, new ArrayList());
            aNodes.add(b);
            nodeToNodes.put(a, aNodes);
            
            List<Integer> bNodes = nodeToNodes.getOrDefault(b, new ArrayList());
            bNodes.add(a);
            nodeToNodes.put(b, bNodes);
        }        
        
        for (int i : nodeToNodes.keySet()) {
            if (nodeToNodes.get(i).size() == 1) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            if (nodeToNodes.size() < 3) {
                return new ArrayList<>(nodeToNodes.keySet());
            }
            
            int size = queue.size();
            
            while (size > 0) {
                int node = queue.poll();
                List<Integer> nodes = nodeToNodes.get(node);
                
                for (int neighbor : nodes) {
                    nodeToNodes.get(neighbor).remove(Integer.valueOf(node));
                    
                    if (nodeToNodes.get(neighbor).size() == 1) {
                        queue.add(neighbor);
                    }
                   
                }
                
                nodeToNodes.remove(node);
                size--;
            }
        }
        
        return new ArrayList<>(queue); 
    }
}