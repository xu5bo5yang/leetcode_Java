/**
 * https://leetcode.com/problems/random-flip-matrix/submissions/
 */
class Solution {
    
    Map<Integer, Integer> flippedPoints;
    int row;
    int col;
    int total;

    public Solution(int n_rows, int n_cols) {
        row = n_rows;
        col = n_cols;
        total = row * col;
        flippedPoints = new HashMap();
    }
    
    public int[] flip() {
        Random random = new Random();
        int rand = random.nextInt(total);
        int x = flippedPoints.getOrDefault(rand, rand);
        
        total--;
        flippedPoints.put(rand, flippedPoints.getOrDefault(total, total));
        
        return new int[]{x / col, x % col};
    }
    
    public void reset() {
        total = row * col;
        flippedPoints = new HashMap();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */