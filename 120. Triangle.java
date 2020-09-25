/**
 * https://leetcode.com/problems/triangle/submissions/
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        
        if (triangle == null) {
            return 0;
        }
        
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prev = triangle.get(i-1);
            List<Integer> cur = triangle.get(i);
            cur.set(0, cur.get(0) + prev.get(0));
            
            for (int j = 1; j < cur.size() - 1; j++) {
                int minSum = cur.get(j) + Math.min(prev.get(j), prev.get(j-1));
                cur.set(j, minSum);
            }
            
            int len = cur.size() - 1;
            cur.set(len, cur.get(len) + prev.get(len-1));
        }
        
        List<Integer> last = triangle.get(triangle.size() - 1);
        for (int i = 0; i < last.size(); i++) {
            result = Math.min(result, last.get(i));
        }
        
        return result;
    }
}