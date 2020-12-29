/**
 * https://leetcode.com/problems/sliding-puzzle/submissions/
 */
class Solution {
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length < 2 || board[0].length < 3) {
            return -1;
        }

        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        int result = 0;        
        String start = "";
        String target = "123450";
        Queue<String> queue = new LinkedList();
        HashSet<String> visited = new HashSet();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            Queue<String> newQueue = new LinkedList();
            
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                int zero = cur.indexOf('0');
               
                if (cur.equals(target)) {
                    return result;
                }

                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    
                    if (visited.contains(next)) {
                        continue;
                    }
                    
                    visited.add(next);
                    newQueue.offer(next);
                }
            }
            
            queue = newQueue;
            result++;
        }
        
        return -1;
    }
    
    String swap(String s, int i, int j) {
        char[] strChar = s.toCharArray();
        char tmp = strChar[i];
        strChar[i] = strChar[j];
        strChar[j] = tmp;
        
        return new String(strChar);
    }
}