/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/submissions/
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 1 || people[0].length < 1) {
            return new int[0][0];
        }
        
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        
        List<int[]> result = new ArrayList<>();
        
        for (int[] person : people) {
            result.add(person[1], person);
        }
        
        return result.toArray(new int[0][0]);
    }
}