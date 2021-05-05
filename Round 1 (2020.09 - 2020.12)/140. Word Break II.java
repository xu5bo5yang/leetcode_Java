/**
 * https://leetcode.com/problems/word-break-ii/submissions/
 */
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return new ArrayList();
        }
        
        Set<String> dict = wordDict.stream().collect(Collectors.toSet());
        Map<String, List<String>> prevResults = new HashMap();
        
        return findSolution(s, dict, prevResults);
    }
    
    List<String> findSolution(String s, Set<String> dict, Map<String, List<String>> prevResults) {
        if (prevResults.containsKey(s)) {
            return prevResults.get(s);
        }
        
        List<String> result = new LinkedList<>();
        
        if (dict.contains(s)) {
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            
            if (dict.contains(left)) {
                List<String> rightSolutions = findSolution(right, dict, prevResults);
                
                for (String prev : rightSolutions) {
                    result.add(left + " " + prev);
                }
            }
        }
        
        prevResults.put(s, result);
        
        return result;
    }
}