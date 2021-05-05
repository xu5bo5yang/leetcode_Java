/**
 * https://leetcode.com/problems/lexicographical-numbers/submissions/
 */
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList();
        int cur = 1;
        
        for (int i = 1; i <= n; i++) {
            result.add(cur);
            
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while (cur % 10 == 9 || cur == n) {
                    cur /= 10;
                }
                
                cur++;
            }
        }
        
        return result;
    }
}