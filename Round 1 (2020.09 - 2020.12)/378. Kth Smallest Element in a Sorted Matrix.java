/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return -1;
        }
        
        int len = matrix.length;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((pair1, pair2) -> matrix[pair1[0]][pair1[1]] - matrix[pair2[0]][pair2[1]]);
        
        for (int i = 0; i < len; i++) {
            queue.add(new int[]{i, 0});
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            count++;
            
            if (count == k) {
                return matrix[pair[0]][pair[1]];
            }
            
            if (pair[1] + 1 < len) {
                queue.add(new int[]{pair[0], pair[1] + 1});
            }
        }
        
        return -1;
    }
}