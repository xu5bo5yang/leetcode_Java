/**
 * https://leetcode.com/problems/open-the-lock/submissions/
 */
class Solution {
    
    private static final String START = "0000";
    public int openLock(String[] deadends, String target) {
        Set<String> ends = new HashSet();
        
        for (String end : deadends) {
            ends.add(end);
        }
        
        if (ends.contains(START)) {
            return -1;
        }
        
        if (target.equals(START)) {
            return 0;
        }
        
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.add(START);
        
        for (int turns = 1; !queue.isEmpty(); turns++) {
            Queue<String> newQueue = new LinkedList();
            
            while(!queue.isEmpty()) {
                String cur = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    for (int dif = 1; dif <= 9; dif += 8) {
                        char[] curChars = cur.toCharArray();
                        curChars[i] = (char)((curChars[i] - '0' + dif) % 10 + '0');
                        
                        String newComb = new String(curChars);
                        
                        if (target.equals(newComb)) {
                            return turns;
                        }
                        
                        if (!ends.contains(newComb) && !visited.contains(newComb)) {
                            newQueue.add(newComb);
                        }
                        
                        visited.add(newComb);
                    } 
                }
            }
            
            queue = newQueue;
        }
        
        return -1;    
    }
}