/**
 * https://leetcode.com/problems/the-skyline-problem/submissions/
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null || buildings.length == 0) {
            return new ArrayList();
        }
        
        List<int[]> heights = new ArrayList();
        
        for (int i = 0; i < buildings.length; i++) {
            heights.add(new int[] {buildings[i][0], -buildings[i][2]});
            heights.add(new int[] {buildings[i][1], buildings[i][2]});
        }
        
        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        
        List<List<Integer>> result = new ArrayList();
        int preHeight = 0;
        PriorityQueue<Integer> skyLine = new PriorityQueue<>((a, b) -> (b - a));
        skyLine.add(0);
        
        for (int[] height : heights) {
            if (height[1] < 0) {
                skyLine.add(-height[1]);
            } else {
                skyLine.remove(height[1]);
            }
            
            int curHeight = skyLine.peek();
            
            if (curHeight != preHeight) {
                List<Integer> point = new ArrayList();
                point.add(height[0]);
                point.add(curHeight);
                result.add(point);
                
                preHeight = curHeight;
            }
        }
        
        return result;
    }
}