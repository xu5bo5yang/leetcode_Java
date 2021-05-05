/**
 * https://leetcode.com/problems/candy/submissions/
 */
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int len = ratings.length;
        int sum = len;
        int[] compareToRight = new int[len];
        int[] compareToLeft = new int[len];

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                compareToLeft[i] = compareToLeft[i-1] + 1;
            }
        }
        
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                compareToRight[i] = compareToRight[i+1] + 1;
            }
        }
        
        for (int i = 0; i < len; i++) {
            sum += Math.max(compareToRight[i], compareToLeft[i]);
        }
        
        return sum;
    }
}