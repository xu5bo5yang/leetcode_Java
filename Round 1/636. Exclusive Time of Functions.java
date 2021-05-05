/**
 * https://leetcode.com/problems/exclusive-time-of-functions/submissions/
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        
        for (String log : logs) {
            String[] splitted = log.split(":");
            int cur = Integer.parseInt(splitted[2]);
            
            if (!stack.isEmpty()) {
                result[stack.peek()] += cur - prev;
            }
            
            prev = cur;
            
            if (splitted[1].equals("start")) {
                stack.push(Integer.parseInt(splitted[0]));
            } else {
                result[stack.pop()]++;
                prev++;
            }
        }
        
        return result;
    }
}