/**
 * https://leetcode.com/problems/complex-number-multiplication/submissions/
 */
class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] splitedA = a.split("\\+");
        String[] splitedB = b.split("\\+");
        
        int a1 = Integer.parseInt(splitedA[0]);
        int a2 = Integer.parseInt(splitedA[1].split("i")[0]);
        int b1 = Integer.parseInt(splitedB[0]);
        int b2 = Integer.parseInt(splitedB[1].split("i")[0]);
        
        return String.valueOf(a1 * b1 - a2 * b2) + "+" + String.valueOf(a1 * b2 + b1 * a2) + "i";
    }
}