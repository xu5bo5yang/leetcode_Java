/**
 * https://leetcode.com/problems/palindrome-pairs/submissions/
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordIndex = new HashMap();
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        
        for (int i = 0; i < words.length; i++) {
            wordIndex.put(words[i], i);
        }
        
        List<List<Integer>> result = new LinkedList();
        
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            String reverse = new StringBuilder(words[i]).reverse().toString(); 

            int left = 0;
            int right = 0;             
            
            while (left <= right) {
                String subString = reverse.substring(left, right);
                Integer index = wordIndex.get(subString);
                if (index != null && index != i) {       
                    if (left == 0 && isPalindrome(reverse.substring(right, len))) {
                        Integer[] solution = new Integer[]{index, i};
                        result.add(Arrays.asList(solution));
                    } else if(right == len && isPalindrome(reverse.substring(0, left))) {
                        Integer[] solution = new Integer[]{i, index};
                        result.add(Arrays.asList(solution)); 
                    }
                }
                
                if (right < len) {
                    right++;
                } else {
                    left++;
                }
            }
        }
        
        return result;
    }
    
    boolean isPalindrome(String s) {   
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if(s.charAt(i) != s.charAt(len - i -1)) {
                return false;
            }
        }
        
        return true;
    }
}