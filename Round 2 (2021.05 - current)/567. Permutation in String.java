class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        
        int left = 0;
        int right = 0;
        int validChars = 0;
        Map<Character, Integer> window = new HashMap();
        Map<Character, Integer> expect = new HashMap();
        
        for (char c : s1.toCharArray()) {
            expect.put(c, expect.getOrDefault(c, 0) + 1);
        }
        
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            
            if (expect.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                
                if (window.get(c).equals(expect.get(c))) {
                    validChars++;
                }
            }
            
            while (right >= left + s1.length()) {
                if (validChars == expect.size()) {
                    return true;
                }
                
                char ch = s2.charAt(left);
                left++;
                
                if (expect.containsKey(ch)) {
                    if (window.get(ch).equals(expect.get(ch))) {
                        validChars--;
                    }
                    
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }
        
        return false;
    }
}