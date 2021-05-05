/**
 * https://leetcode.com/problems/minimum-window-substring/submissions/
 */
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || 
            t == null || t.length() == 0) {
            return "";
        }
        
        int left = 0;
        int leftAns = 0;
        int right = 0;
        int rightAns = s.length();
        boolean findAns = false;
        Map<Character, Integer> tMap = new HashMap();
        Map<Character, Integer> sMap = new HashMap();
        
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int tChars = tMap.size();
        int sChars = 0;
                
        int[] ans = {-1, 0, 0};
        
        while (right < s.length()) {
            char r = s.charAt(right);
            sMap.put(r, sMap.getOrDefault(r, 0) + 1);
            
            if (tMap.containsKey(r) && sMap.get(r).intValue() == tMap.get(r).intValue()) {
                sChars++;
            }
            
            while (left <= right && sChars == tChars) {
                char l = s.charAt(left);
                
                if (right - left < rightAns - leftAns) {
                    rightAns = right;
                    leftAns = left;
                }
                
                sMap.put(l, sMap.get(l) - 1);
                if (tMap.containsKey(l) && sMap.get(l).intValue() < tMap.get(l).intValue()) {
                    sChars--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return rightAns == s.length() ? "" : s.substring(leftAns, rightAns + 1);
    }
}