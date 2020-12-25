/**
 * https://leetcode.com/problems/contain-virus/submissions/
 */
class Solution {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int containVirus(int[][] grid) {
        int result = 0;
        
        while (true) {
            int id = 0;
            Set<Integer> visited = new HashSet();
            Map<Integer, Set<Integer>> islands = new HashMap();
            Map<Integer, Set<Integer>> scores = new HashMap();
            Map<Integer, Integer> walls = new HashMap();
            
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && !visited.contains(i * grid[0].length + j)) {
                        dfs(visited, grid, islands, scores, walls, i, j, id);
                        id++;
                    }
                }
            }
            
            if (islands.isEmpty()) {
                break;
            }
            
            int maxVirus = 0;
            
            for (int i = 0; i < id; i++) {
                if (scores.getOrDefault(maxVirus, new HashSet()).size() < scores.getOrDefault(i, new HashSet()).size()) {
                    maxVirus = i;
                }
            }
            
            result += walls.getOrDefault(maxVirus, 0);
            
            for (int i = 0; i < islands.size(); i++) {
                for (int island : islands.get(i)) {
                    int x = island / grid[0].length;
                    int y = island % grid[0].length;
                    
                    if (i == maxVirus) {
                        grid[x][y] = -1; 
                    } else {                             
                        for (int [] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            
                            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 0) {
                                grid[nx][ny] = 1;
                            }
                        }
                    }                           
                }
            }
        }
        
        return result;
    }
    
    void dfs(Set<Integer> visited, int[][] grid, Map<Integer, Set<Integer>> islands, Map<Integer, Set<Integer>> scores, Map<Integer, Integer> walls, int i, int j, int id) {
        if (!visited.add(i * grid[0].length + j)) {
            return;
        }
        
        islands.computeIfAbsent(id, value -> new HashSet<>()).add(i * grid[0].length + j);
        
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                continue;
            }
            
            if (grid[x][y] == 1) {
                dfs(visited, grid, islands, scores, walls, x, y, id);
            }
            
            if (grid[x][y] == 0) {
                scores.computeIfAbsent(id, value -> new HashSet<>()).add(x * grid[0].length + y);
                walls.put(id, walls.getOrDefault(id, 0) + 1);
            }
        }
    }
}