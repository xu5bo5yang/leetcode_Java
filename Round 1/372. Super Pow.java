/**
 * https://leetcode.com/problems/super-pow/submissions/
 */
class Solution {
    int MAGIC_NUMBER = 1337;
    
    public int superPow(int a, int[] b) {
        if(b == null || b.length < 1) {
            return 0;
        }
        
        a = a % MAGIC_NUMBER;
        
        int result = 1;
        int len = b.length;
        
        for (int i = 0; i < len; i++) {
            result = ((pow(result, 10) * pow(a, b[i])) % MAGIC_NUMBER);
        }
        return result;
    }
    
    int pow(int a, int b){
        if(b == 0) {
            return 1;
        }
        
        if(b == 1) {
            return a;
        }
        
        int x = pow(a, b / 2);
        x = (x * x) % MAGIC_NUMBER;
        
        if((b % 2) == 1) {
            x = (x * a) % MAGIC_NUMBER;
        }
        return x;
    }
}