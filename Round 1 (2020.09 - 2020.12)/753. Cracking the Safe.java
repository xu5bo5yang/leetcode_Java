/**
 * https://leetcode.com/problems/cracking-the-safe/submissions/
 */
class Solution {
    public String crackSafe(int n, int k) {
        int total = (int) (Math.pow(k, n));
        StringBuilder result = new StringBuilder();
        Set<String> visited = new HashSet();
        
        for (int i = 0; i < n; i++) {
            result.append('0');
        }
        
        visited.add(result.toString());

        dfs(result, total, visited, n, k);

        return result.toString();
    }
    
    boolean dfs(StringBuilder sb, int goal, Set<String> visited, int n, int k) {
        if (visited.size() == goal) {
            return true;
        }
        
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                
                if (dfs(sb, goal, visited, n, k)) {
                    return true;
                } else {
                    visited.remove(next);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        
        return false;
    }
}