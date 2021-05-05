/**
 * https://leetcode.com/problems/sort-characters-by-frequency/submissions/
 */
class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }
        
        int maxCount = 0;
        Map<Character, Integer> charCount = new HashMap();
        
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            
            maxCount = Math.max(maxCount, charCount.get(c));
        }
        
        List<Character>[] buckets = new ArrayList[maxCount + 1];
        
        for (char key : charCount.keySet()) {
            int count = charCount.get(key);
            
            if (buckets[count] == null) {
                buckets[count] = new ArrayList();
            }
            
            buckets[count].add(key);
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(c);
                    }
                }
            }
        }
        
        return result.toString();
    }
}