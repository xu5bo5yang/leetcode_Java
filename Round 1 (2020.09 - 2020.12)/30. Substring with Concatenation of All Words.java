/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/submissions/
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        int n = s.length();
        int num = words.length;
        int len = words[0].length();
        
        for (int i = 0; i < n - num * len + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                
                j++;
            }
            
            if (j == num) {
                result.add(i);
            }
        }
        return result;
    }
}