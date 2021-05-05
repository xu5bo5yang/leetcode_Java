/**
 * https://leetcode.com/problems/palindrome-partitioning/submissions/
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<String> curList = new ArrayList();
        List<List<String>> result = new ArrayList();
        
        findSolution(result, curList, s, 0);
        
        return result;
    }
    
    void findSolution(List<List<String>> result, List<String> curList, String s, int left) {
        if (left >= s.length()) {
            List<String> solution = new ArrayList();
            solution.addAll(curList);
            
            result.add(solution);
            return;
        }
        
        for (int right = left + 1; right <= s.length(); right++) {
            String subString = s.substring(left, right);
            
            if (isPalindrome(subString)) {
                curList.add(subString);
                findSolution(result, curList, s, right);
                curList.remove(curList.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}