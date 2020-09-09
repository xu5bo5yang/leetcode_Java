/**
 * https://leetcode.com/problems/count-and-say/submissions/
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String last = countAndSay(n-1);
            StringBuilder result = new StringBuilder();
            
            int count = 1;
            for (int i = 0; i < last.length(); i++) {
                char cur = last.charAt(i);
                
                if (i < last.length()-1 && last.charAt(i+1) == cur) {
                    count++;
                } else {
                    result.append(String.valueOf(count) + cur);
                    count = 1;
                }
            }
            
            return result.toString();
        }
    }
}