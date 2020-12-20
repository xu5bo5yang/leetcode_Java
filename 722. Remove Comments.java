/**
 * https://leetcode.com/problems/remove-comments/submissions/
 */
class Solution {
    public List<String> removeComments(String[] source) {
        if (source == null || source.length < 1) {
            return new ArrayList();
        }
        
        List<String> result = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();     
        boolean isComment = false;
        
        for (String line : source) {
            for (int i = 0; i < line.length(); i++) {
                if (isComment) {
                    if (line.charAt(i) == '*' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                        isComment = false;
                        i++;
                    }
                } else {
                    if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '/') {
                        break;
                    } else if (line.charAt(i) == '/' && i < line.length() - 1 && line.charAt(i + 1) == '*') {
                        isComment = true;
                        i++;
                    } else {
                        stringBuilder.append(line.charAt(i));
                    }
                }
            }
            
            if (!isComment && stringBuilder.length() > 0) {
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        
        return result;
    }
}