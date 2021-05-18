class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        
        int left = 0;
        int right = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        int validChars = 0;
        Map<Character, Integer> window = new HashMap();
        Map<Character, Integer> expect = new HashMap();
        
        for (char c : t.toCharArray()) {
            expect.put(c, expect.getOrDefault(c, 0) + 1);
        }
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            if (expect.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                
                if (window.get(c).equals(expect.get(c))) {
                    validChars++;
                }
            }
            
            while (validChars == expect.size()) {
                if (right - left < (end - start)) {
                    start = left;
                    end = right;
                }
                
                char ch = s.charAt(left);
                left++;
                
                if (expect.containsKey(ch)) {
                    if (window.get(ch).equals(expect.get(ch))) {
                        validChars--;
                    }
                    
                    window.put(ch, window.getOrDefault(ch, 0) - 1);
                }
            }
        }
        
        if (end == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, end);
        }
    }
}