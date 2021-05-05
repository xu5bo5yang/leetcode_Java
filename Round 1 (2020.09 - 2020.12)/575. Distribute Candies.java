/**
 * https://leetcode.com/problems/distribute-candies/submissions/
 */
class Solution {
    public int distributeCandies(int[] candyType) {
        if (candyType == null || candyType.length < 1) {
            return 0;
        }
        
        Set<Integer> types = new HashSet();
        
        for (int type : candyType) {
            types.add(type);
        }
        
        int count = candyType.length / 2;
        
        return count > types.size() ? types.size() : count;
    }
}