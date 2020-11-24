/**
 * https://leetcode.com/problems/beautiful-arrangement/submissions/
 */
class Solution {
    
    int count;
    
    public int countArrangement(int N) {
        if (N < 1) {
            return 0;
        }
        
        count = 0;
        findArrangement(N, 1, new int[N + 1]);
        
        return count;
    }
    
    void findArrangement(int N, int pos, int[] prev) {
        if (pos > N) {
            count++;
            
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (prev[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                prev[i] = 1;
                
                findArrangement(N, pos + 1, prev);
                
                prev[i] = 0;
            }
        }
    }
}