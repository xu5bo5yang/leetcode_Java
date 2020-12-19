/**
 * https://leetcode.com/problems/falling-squares/submissions/
 */
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        int max = 0;
        List<Integer> result = new ArrayList();
        TreeMap<Integer, Integer> startHeight = new TreeMap();
        startHeight.put(0, 0); 
        
        for (int[] pos : positions) {
            int start = pos[0];
            int end = start + pos[1];
            Integer from = startHeight.floorKey(start);
            int height = startHeight.subMap(from, end).values().stream().max(Integer::compare).get() + pos[1];
            max = Math.max(height, max);
            
            result.add(max);

            int lastHeight = startHeight.floorEntry(end).getValue();
            
            startHeight.put(start, height);
            startHeight.put(end, lastHeight);
            startHeight.keySet().removeAll(new HashSet(startHeight.subMap(start, false, end, false).keySet()));
        }
        
        return result;
    }
}