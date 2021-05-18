class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList();
        int left = 0;
        int right = 0;
        int validChars = 0;
        Map<Character, Integer> window = new HashMap();
        Map<Character, Integer> expect = new HashMap();
        
        for (char c : p.toCharArray()) {
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
                if (right - left == p.length()) {
                    result.add(left);
                }
                
                char ch = s.charAt(left);
                left++;
                
                if (expect.containsKey(ch)) {
                    if (window.get(ch).equals(expect.get(ch))) {
                        validChars--;
                    }
                    
                    window.put(ch, window.get(ch) - 1);
                }
            }
        }
        
        return result;
    }
}