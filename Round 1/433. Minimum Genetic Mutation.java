/**
 * https://leetcode.com/problems/minimum-genetic-mutation/submissions/
 */
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null) {
            return -1;
        }
        
        if (start.equals(end)) {
            return 0;
        }
        
        int mutations = 0;
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet();
        Set<String> bankSet = new HashSet();
        Queue<String> queue = new LinkedList();
        
        for(String gene : bank) {
            bankSet.add(gene);
        }
        
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size > 0) {
                String cur = queue.poll();
                
                if (cur.equals(end)) {
                    return mutations;
                }
                
                char[] curChars = cur.toCharArray();
                for (int i = 0; i < curChars.length; i++) {
                    char prev = curChars[i];
                    
                    for (char c : genes) {
                        curChars[i] = c;
                        
                        String mutated = new String(curChars);
                        
                        if (!visited.contains(mutated) && bankSet.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                    
                    curChars[i] = prev;
                }
                
                size--;
            }
            
            mutations++;
        }
        
        return -1;
    }
}