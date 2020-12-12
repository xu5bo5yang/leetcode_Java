/**
 * https://leetcode.com/problems/baseball-game/submissions/
 */
class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length < 1) {
            return 0;
        }
        
        Stack<Integer> scores = new Stack();
        
        for (String op : ops) {
            if (op.equals("+")) {
                int prev = scores.pop();
                int newScore = prev + scores.peek();
                
                scores.push(prev);
                scores.push(newScore);
            } else if (op.equals("D")) {
                scores.push(scores.peek() * 2);
            } else if (op.equals("C")) {
                scores.pop();
            } else {
                scores.push(Integer.parseInt(op));
            }
        }
        
        int result = 0;
        
        while (!scores.isEmpty()) {
            result += scores.pop();
        }
        
        return result;
    }
}