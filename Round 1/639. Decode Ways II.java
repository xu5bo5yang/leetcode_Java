/**
 * https://leetcode.com/problems/decode-ways-ii/submissions/
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        long[] result = new long[s.length() + 1];
        result[0] = 1;
        result[1] = (s.charAt(0) == '*') ? 9 : 1;

        for (int i = 2; i <= s.length(); i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);

            if (second == '*') {
                result[i] += 9 * result[i-1];
            } else if (second > '0') {
                result[i] += result[i-1];
            }
            
            if (first == '*') {
                if (second == '*') {
                    result[i] += 15 * result[i - 2];
                } else if(second <= '6') {
                    result[i] += 2 * result[i - 2];
                } else {
                    result[i] += result[i - 2];
                }
            } else if (first == '1' || first == '2') {
                if (second == '*') {
                    if (first == '1') {
                       result[i] += 9 * result[i - 2]; 
                    } else {
                       result[i] += 6 * result[i - 2]; 
                    }
                } else if(((first - '0') * 10 + (second - '0')) <= 26 ) {
                    result[i] += result[i - 2];    
                }
            }

            result[i] %= 1000000007;
        }

        return (int) result[s.length()];
    }
}