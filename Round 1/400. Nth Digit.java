/**
 * https://leetcode.com/problems/nth-digit/submissions/
 */
class Solution {
    public int findNthDigit(int n) {
        int len = 1;
		int start = 1;
		long range = 9;

		while (n > len * range) {
			n -= len * range;
			
            range *= 10;
			start *= 10;
            len++;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
        
		return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}