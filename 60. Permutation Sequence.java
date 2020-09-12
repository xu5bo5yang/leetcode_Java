/**
 * https://leetcode.com/problems/permutation-sequence/submissions/
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> candidates = new ArrayList<Integer>();
        int choices = 1;
        
        for (int i = 1; i < n; i++) {
            candidates.add(i);
            choices *= i;
        }
        candidates.add(n);
        
        StringBuilder result = new StringBuilder();

        k = k - 1;
        while (candidates.size() > 0) {
            result.append(candidates.remove(k / choices));
            k = k % choices;
            
            if (candidates.size() == 0) {
                break;
            }
            
            choices = choices / candidates.size();
        }
        
        return result.toString();
    }
}