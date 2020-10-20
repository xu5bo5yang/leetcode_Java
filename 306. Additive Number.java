/**
 * https://leetcode.com/problems/additive-number/submissions/
 */
class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num == null) {
            return false;
        }
        
        num = num.trim();
        if(num.length() < 3) {
            return false;
        }
        
        for(int i = 2; i <= num.length()- i/2 + 2; i++){
            for(int j = 1; j < i; j++){
                if (num.length() - i < Math.max(j, i-j)) {
                    continue;
                }
                
                if ((j >= 2 && num.substring(0, 1).equals("0")) ||
                    (i - j > 1 && num.substring(j, j+1).equals("0")) || 
                    (num.length() - i > 1 && num.substring(i, i+1).equals("0"))) {
                    continue;
                }
                
                long first = Long.parseLong(num.substring(0, j));
                long second = Long.parseLong(num.substring(j, i));
                
                if (canFormAdditive(num.substring(i), first, second)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean canFormAdditive(String num, long first, long second){
        if (num.isEmpty()) {
            return true;
        }
        
        long third = first + second;
        String thirdStr = String.valueOf(third);
        
        if (num.startsWith(thirdStr)) {
            return canFormAdditive(num.substring(thirdStr.length()), second, third);
        }
        
        return false;
    }
}