/**
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/submissions/
 */
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() < 1) {
            return new int[0];
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(i -> nums.get(i[0]).get(i[1])));
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            queue.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        
        while (queue.size() == nums.size()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            
            if (right - left > max - nums.get(row).get(col)) {
                left = nums.get(row).get(col);
                right = max;
            }
            
            if (col + 1 < nums.get(row).size()) {
                queue.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        
        return new int[]{left, right};
    }
}