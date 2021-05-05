/**
 * https://leetcode.com/problems/couples-holding-hands/submissions/
 */
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] couple = new int[n];
        int[] pos = new int[n];
        
        for (int i = 0; i < n; i++) {
            couple[i] = i % 2 == 0 ? i + 1 : i - 1;
            pos[row[i]] = i; 
        }
        
        int result = 0;
        
        for (int i = 0; i < n; i += 2) {  
            int j = i + 1;
            
            if (row[j] != couple[row[i]]) {
                j = pos[couple[row[i]]];
                
                swap(row, i+1, j);
                swap(pos, row[i+1], row[j]);
                
                result++;
            }
        }
        
        return result;
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}