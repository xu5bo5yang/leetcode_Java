/**
 * https://leetcode.com/problems/bulls-and-cows/submissions/
 */
class Solution {
    public String getHint(String secret, String guess) {
        int aCount = 0;
        int bCount = 0;
        int[] digits = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            
            if (s == g) {
                aCount++;
            } else {
                digits[s]++;
                digits[g]--;
                
                if (digits[s] <= 0) {
                    bCount++;
                }
                
                if (digits[g] >= 0) {
                    bCount++;
                }
            }
        }
        
        return aCount + "A" + bCount + "B";
    }
}