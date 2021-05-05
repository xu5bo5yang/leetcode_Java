/**
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/submissions/
 */
class Solution {
    public String toHex(int num) {
        char[] hexChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        
        if (num == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        while (num != 0) {
            result.insert(0, hexChars[num & 15]);
            num = (num >>> 4);
        }
        
        return result.toString();
    }
}