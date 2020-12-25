/**
 * https://leetcode.com/problems/partition-labels/submissions/
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() < 1) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();
        int[] charCount = new int[26];
        Set<Character> existingChars = new HashSet();
        
        for (char c : S.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        int left = 0;
        int right = left;
        
        while (right < S.length()) {
            char c = S.charAt(right);
            
            charCount[c - 'a']--;
            
            if (charCount[c - 'a'] == 0) {
                existingChars.remove(c);
            } else {
                existingChars.add(c);
            }
            
            if (existingChars.isEmpty()){
                result.add(right - left + 1);
                left = right + 1;
            }
            
            right++;
        }
        
        return result;
    }
}