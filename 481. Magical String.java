/**
 * https://leetcode.com/problems/magical-string/submissions/
 */
class Solution {
    public int magicalString(int n) {
        if (n < 1) {
            return 0;
        }
        
        if (n <= 3) {
            return 1;
        }
        
        int[] magical = new int[n + 1];
        magical[0] = 1; 
        magical[1] = 2; 
        magical[2] = 2;
        
        int left = 2;
        int right = 3;
        int num = 1;
        int result = 1;
        
        while (right < n) {
            for (int i = 0; i < magical[left]; i++) {
                magical[right] = num;
                
                if (num == 1 && right < n) {
                    result++;
                }
                
                right++;
            }
            
            num = num ^ 3;
            left++;
        }
        
        return result;
    }
}