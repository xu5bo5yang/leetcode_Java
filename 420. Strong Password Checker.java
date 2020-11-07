/**
 * https://leetcode.com/problems/strong-password-checker/submissions/
 */
class Solution {
    public int strongPasswordChecker(String s) {
        if (s == null) {
            return 6;
        }
        
        int requiredChar = getRequiredChar(s);
        int len = s.length();
        char[] chars = s.toCharArray();
        
        if (len < 6) {
            return Math.max(requiredChar, 6 - len);
        }

        int replace = 0;
        int deleteOne = 0;
        int deleteTwo = 0;
        int repeat = 1;

        for (int i = 0; i < len; i += repeat) {
            repeat = 1;
            
            while (i + repeat < len && chars[i + repeat] == chars[i + repeat - 1]) {
                repeat++;
            }
            
            if (3 <= repeat) {
                replace += repeat / 3;
                
                if (repeat % 3 == 0) {
                    deleteOne += 1;
                }
                
                if (repeat % 3 == 1) {
                    deleteTwo += 2;
                }
            }
        }
        
        if (len <= 20) {
            return Math.max(requiredChar, replace);
        }

        int deleteCount = len - 20;
        
        replace -= Math.min(deleteCount, deleteOne);
        replace -= Math.min(Math.max(deleteCount - deleteOne, 0), deleteTwo) / 2;
        replace -= Math.max(deleteCount - deleteOne - deleteTwo, 0) / 3;

        return deleteCount + Math.max(requiredChar, replace);
    }
    
    int getRequiredChar(String s) {
        int lowercase = 1;
        int uppercase = 1;
        int digit = 1;
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercase = 0;
            } else if (Character.isUpperCase(c)) {
                uppercase = 0;
            } else if (Character.isDigit(c)) {
                digit = 0;
            }
        }
        
        return lowercase + uppercase + digit;
    }
}