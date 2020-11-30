/**
 * https://leetcode.com/problems/find-the-closest-palindrome/submissions/
 */
class Solution {
    public String nearestPalindromic(String n) {
        if (n == null || n.length() < 1) {
            return n;
        }
        
        int len = n.length();
        int midPoint = len % 2 == 0 ? len / 2 - 1: len / 2;
        long leftHalf = Long.parseLong(n.substring(0, midPoint + 1));
        
        List<Long> candidates = new ArrayList<>();
        candidates.add(getPalindrome(leftHalf, len % 2 == 1));
        candidates.add(getPalindrome(leftHalf + 1, len % 2 == 1));
        candidates.add(getPalindrome(leftHalf - 1, len % 2 == 1));
        candidates.add((long)Math.pow(10, len - 1) - 1);
        candidates.add((long)Math.pow(10, len) + 1);
        
        long diff = Long.MAX_VALUE;
        long result = 0;
        long nNum = Long.parseLong(n);
        
        for (long candidate : candidates) {
            if (candidate == nNum) {
                continue;
            }
            
            if (Math.abs(candidate - nNum) < diff) {
                diff = Math.abs(candidate - nNum);
                result = candidate;
            } else if (Math.abs(candidate - nNum) == diff) {
                result = Math.min(result, candidate);
            }
        }
        
        return String.valueOf(result);
    }
    
    long getPalindrome(long leftHalf, boolean isOdd) {
        long result = leftHalf;
        
        if (isOdd) {
            leftHalf = leftHalf / 10;
        }
        
        while (leftHalf > 0) {
            result = result * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        
        return result;
    }
}