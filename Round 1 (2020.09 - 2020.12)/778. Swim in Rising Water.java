/**
 * https://leetcode.com/problems/swim-in-rising-water/submissions/
 */
class Solution {
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return -1;
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int len = grid.length;
        boolean[][] visited = new boolean[len][len];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{0, 0, grid[0][0]});
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            visited[cell[0]][cell[1]] = true;
            
            if (cell[0] == len - 1 && cell[1] == len - 1) {
                return Math.max(cell[2], grid[len - 1][len - 1]);
            }
            
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                
                if (x < 0 || x == len || y < 0 || y == len || visited[x][y]) {
                    continue;
                }
                
                queue.offer(new int[]{x, y, Math.max(cell[2], grid[x][y])});
            }
        }
        
        return -1;
    }
}