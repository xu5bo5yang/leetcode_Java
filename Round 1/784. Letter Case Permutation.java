/**
 * https://leetcode.com/problems/letter-case-permutation/submissions/
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() < 1) {
            return new ArrayList();
        }
        
        List<String> result = new ArrayList();
        
        addChar(result, S.toCharArray(), 0);
        
        return result;
    }
    
    void addChar(List<String> result, char[] sChar, int index) {
        if (index == sChar.length) {
            result.add(new String(sChar));
            
            return;
        }
        
        if (Character.isLetter(sChar[index])) {
            sChar[index] = Character.toLowerCase(sChar[index]);
            addChar(result, sChar, index + 1);
            
            sChar[index] = Character.toUpperCase(sChar[index]);
            addChar(result, sChar, index + 1);
        } else {
            addChar(result, sChar, index + 1);
        }
        
        return;
    }
}