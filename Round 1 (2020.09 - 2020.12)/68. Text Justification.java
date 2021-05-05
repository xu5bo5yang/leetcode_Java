/**
 * https://leetcode.com/problems/text-justification/submissions/
 */
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int left = 0;
        int right = 1;
        int curWidth = words[0].length();
        
        while (left < words.length && right < words.length) {
            if (curWidth + words[right].length() + 1 > maxWidth) {
                right--;
                addString(words, left, right, maxWidth, curWidth, result);
                left = right + 1;
                right = left + 1;
                
                if (left >= words.length) {
                    break;
                }
                curWidth = words[left].length();
            } else {
                curWidth += words[right].length() + 1;
                right++;
            }
        }
        
        if (left < words.length) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[left]);
            curWidth = words[left].length();
            
            for (int i = left + 1; i < words.length; i++) {
                sb.append(" ");
                sb.append(words[i]);
                curWidth += words[i].length() + 1;
            }
            
            sb.append(buildSpaceString(maxWidth - curWidth));
            
            result.add(sb.toString());
        }
        
        return result;
    }
    
    void addString(String[] words, int left, int right, int maxWidth, int curWidth, List<String> result) {
        int spaces = right == left ? 0 : (maxWidth - curWidth) / (right - left) + 1;
        int extraSpaces = right == left ? maxWidth - curWidth : (maxWidth - curWidth) % (right - left);
        
        StringBuilder sb = new StringBuilder();
        sb.append(words[left]);
        
        for (int i = left + 1; i <= right; i++) {
            if (extraSpaces > 0) {
                sb.append(buildSpaceString(spaces+1));
                extraSpaces--;
            } else {
                sb.append(buildSpaceString(spaces));
            }
            sb.append(words[i]);
        }
        sb.append(buildSpaceString(extraSpaces));
        result.add(sb.toString());
    }
    
    String buildSpaceString(int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        
        return sb.toString();
    }
}