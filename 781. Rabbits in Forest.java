/**
 * https://leetcode.com/problems/rabbits-in-forest/submissions/
 */
class Solution {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length < 1) {
            return 0;
        }
        
        int result = 0;
        Map<Integer, Integer> count = new HashMap();
        
        for (int answer : answers) {
            count.put(answer, count.getOrDefault(answer, 0) + 1);
            
            if (count.get(answer) == 1) {
                result += answer + 1;
            }
            
            if (count.get(answer) > answer) {
                count.remove(answer);
            }
        }
        
        return result;
    }
}