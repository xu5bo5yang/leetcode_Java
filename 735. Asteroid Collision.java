/**
 * https://leetcode.com/problems/asteroid-collision/submissions/
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 1) {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            if (asteroid < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                    int prev = stack.pop();
                    
                    if (Math.abs(asteroid) == prev) {
                        asteroid = 0;
                    } else {
                        asteroid = Math.abs(asteroid) > prev ? asteroid : prev;
                    }
                }
            }
            
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        
        return stack.stream().mapToInt(x -> x).toArray();
    }
}