/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/submissions/
 */
class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList();
        
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int height = forest.get(i).get(j);
                
                if (height > 1) {
                    trees.add(new int[]{i, j, height});
                }
            }
        }
        
        Collections.sort(trees, (a, b) -> (a[2] - b[2]));
        
        int result = 0;
        int x = 0;
        int y = 0;
        
        for (int[] tree: trees) {
            int dist = bfs(forest, x, y, tree[0], tree[1]);
            
            if (dist < 0) {
                return -1;
            } else {
                result = result + dist;
                x = tree[0];
                y = tree[1];
            }
        }
        
        return result;
    }
    
    int bfs(List<List<Integer>> forest, int x, int y, int tx, int ty) {
        int m = forest.size();
        int n = forest.get(0).size();
        int dist = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList();
        
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
           
            for (int j = 0; j < size; j++) {
                int[] cur = queue.poll();
                
                if (cur[0] == tx && cur[1] == ty) {
                    return dist;
                }
                
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dirs[i][0];
                    int ny = cur[1] + dirs[i][1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && forest.get(nx).get(ny) >= 1) {
                      visited[nx][ny] = true;
                      queue.add(new int[]{nx, ny});
                   }
                }
            }
            
            dist++;
        }
        
        return -1;
    }
}