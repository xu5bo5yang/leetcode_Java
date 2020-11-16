/**
 * https://leetcode.com/problems/repeated-substring-pattern/submissions/
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        for(int len = 1; len <= s.length() / 2; len++){
            if (s.length() % len != 0) {
                continue;
            }
            
            String pattern = s.substring(0, len);
            int i = len;
            int j = i + len - 1;
            
            while(j < s.length()){
                String substr = s.substring(i, j + 1);
                
                if(!pattern.equals(substr)) {
                    break;
                }
                
                i += len;
                j += len;
            }
			
            if(i == s.length()) {
                return true;
            }
        }
        
        return false;
    }
}