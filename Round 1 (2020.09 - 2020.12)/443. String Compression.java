/**
 * https://leetcode.com/problems/string-compression/submissions/
 */
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length < 1) {
            return 0;
        }
        
        int i = 0;
        int start = 0;
        
        while (start < chars.length) {
            if (start == chars.length - 1) {
                chars[i] = chars[start];
                i++;
                break;
            }
            
            int nextIndex = start + 1;
            
            while (nextIndex < chars.length && chars[nextIndex] == chars[start]) {
                nextIndex++;
            }
            
            chars[i] = chars[start];
            i++;
            
            int count = nextIndex - start;

            if (count > 1) {
                StringBuilder sb = new StringBuilder();
                
                while (count > 0) {
                    sb.append(count % 10);
                    count /= 10;
                }
                
                sb.reverse();
                
                String countStr = sb.toString();
                
                for (int j = 0; j < countStr.length(); i++, j++) {
                    chars[i] = countStr.charAt(j);
                }
            }
            
            start = nextIndex;
        }
        
        return i;
    }
}