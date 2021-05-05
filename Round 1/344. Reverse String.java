/**
 * https://leetcode.com/problems/reverse-string/submissions/
 */
class Solution {
    public void reverseString(char[] s) {
        char tmp = ' ';
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            
            left++;
            right--;
        }
    }
}