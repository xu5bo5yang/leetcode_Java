/**
 * https://leetcode.com/problems/longest-absolute-file-path/submissions/
 */
class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        Stack<Integer> stack = new Stack();
        int result = 0;
        int curLen = 0;

        for (String path : paths) {
            int level = countLevel(path);

            while (stack.size() > level) {
                curLen -= stack.pop();
            }

            int len = path.replaceAll("\t", "").length() + 1;
            curLen += len;

            if (path.contains(".")) {
                result = Math.max(result, curLen - 1);
            }
            
            stack.add(len);
        }
        
        return result;
    }
    
    int countLevel(String s) {
        String cur = s.replaceAll("\t", "");
        return s.length() - cur.length();
    }
}