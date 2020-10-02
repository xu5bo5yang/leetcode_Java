/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/submissions/
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        result.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        result.append(num / den);
        num %= den;
        
        if (num == 0) {
            return result.toString();
        }
        
        result.append(".");
        Map<Long, Integer> indexMap = new HashMap();
        
        while (num != 0) {
            indexMap.put(num, result.length());
            
            num *= 10;
            result.append(num / den);
            num %= den;
            
            if (indexMap.containsKey(num)) {
                result.insert(indexMap.get(num), "(");
                result.append(")");
                break;
            }
        }
        
        return result.toString();
    }
}