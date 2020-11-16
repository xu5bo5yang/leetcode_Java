/**
 * https://leetcode.com/problems/poor-pigs/submissions/
 */
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int result = 0;
        
        while (Math.pow(minutesToTest / minutesToDie + 1, result) < buckets) {
            result += 1;
        }
        return result;
    }
}