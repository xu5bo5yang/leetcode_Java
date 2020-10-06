/**
 * https://leetcode.com/problems/repeated-dna-sequences/submissions/
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet();
        Set<String> result = new HashSet();
        
        if (s == null || s.length() == 0) {
            return new ArrayList();
        }
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            
            if (visited.contains(str)) {
                result.add(str);
            } else {
                visited.add(str);
            }
        }
        
        return result.stream().collect(Collectors.toList());
    }
}