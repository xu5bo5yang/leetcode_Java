/**
 * https://leetcode.com/problems/integer-to-english-words/submissions/
 */
class Solution {
    String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        return convertToString(num);
    }

    String convertToString(int num) {
        String result = new String();
        
        if (num < 20) {
            result = belowTwenty[num];
        } else if (num < 100) {
            result = belowHundred[num/10] + " " + convertToString(num % 10);
        } else if (num < 1000) {
            result = convertToString(num/100) + " Hundred " +  convertToString(num % 100);
        } else if (num < 1000000) {
            result = convertToString(num/1000) + " Thousand " +  convertToString(num % 1000);
        } else if (num < 1000000000) {
            result = convertToString(num/1000000) + " Million " +  convertToString(num % 1000000);
        } else {
            result = convertToString(num/1000000000) + " Billion " + convertToString(num % 1000000000);
        }
          
        return result.trim();
    }
}