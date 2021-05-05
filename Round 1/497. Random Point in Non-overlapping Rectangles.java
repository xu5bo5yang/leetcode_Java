/**
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/submissions/
 */
class Solution {
    
    private int[][] rectangles;
    private TreeMap<Integer, Integer> areaToRectangle;
    private int totalArea;

    public Solution(int[][] rects) {
        rectangles = rects;
        areaToRectangle = new TreeMap<>();
        totalArea = 0;
        
        for (int i = 0; i < rectangles.length; i++) {
            totalArea += (rectangles[i][2] - rectangles[i][0] + 1) * (rectangles[i][3] - rectangles[i][1] + 1);
            areaToRectangle.put(totalArea, i);
        }
    }
    
    public int[] pick() {
        Random random = new Random();
        int rand = random.nextInt(totalArea);
        int index = areaToRectangle.higherKey(rand);
        int[] rectangle = rectangles[areaToRectangle.get(index)];
        
        int x = rectangle[0] + (index - rand - 1) % (rectangle[2] - rectangle[0] + 1);
        int y = rectangle[1] + (index - rand - 1) / (rectangle[2] - rectangle[0] + 1);
        
        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */