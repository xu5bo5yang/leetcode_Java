/**
 * https://leetcode.com/problems/brick-wall/submissions/
 */
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() < 1) {
            return 0;
        }
        
        int count = 0;
        Map<Integer, Integer> widthCount = new HashMap();
        
        for (List<Integer> row : wall) {
            int width = 0;
            
            for (int i = 0; i < row.size() - 1; i++) {
                width += row.get(i);
                widthCount.put(width, widthCount.getOrDefault(width, 0) + 1);
                count = Math.max(count, widthCount.get(width));
            }
        }
        
        return wall.size() - count;
    }
}