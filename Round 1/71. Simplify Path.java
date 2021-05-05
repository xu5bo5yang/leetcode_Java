/**
 * https://leetcode.com/problems/simplify-path/submissions/
 */
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        
        String[] split = path.split("/");
        String[] dirs = new String[split.length];
        int pos = 0;
        
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (pos > 0) {
                    pos--;
                }
            } else if (!split[i].equals(".") && !split[i].equals("")) {
                dirs[pos] = split[i];
                pos++;
            }
        }

        String result = "";
        for (int i = 0; i < pos; i++) {
            result += "/" + dirs[i];
        }
        
        return result.length() == 0 ? "/" : result;
    }
}