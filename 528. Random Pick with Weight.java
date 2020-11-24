/**
 * https://leetcode.com/problems/random-pick-with-weight/submissions/
 */
class Solution {

    int[] sum;
    
    public Solution(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        
        sum = w;
    }
    
    public int pickIndex() {
        Random random = new Random();
        int index = Arrays.binarySearch(sum, random.nextInt(sum[sum.length - 1]) + 1);
        
        if (index < 0) {
            return -1 - index;
        } else {
            return index;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */