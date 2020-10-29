/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/submissions/
 */
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < row; i ++) {
            int[] colSum = new int[col];
            
            for (int j = i; j < row; j ++) {
                for (int c = 0; c < col; c ++) {
                    colSum[c] += matrix[j][c];
                }
                
                result = Math.max(result, findMax(colSum, k));
            }
        }
        
        return result;
    }
    
    int findMax(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);
    
        for(int i = 0;i < nums.length; i++){
            int tmp = sum + nums[i];
            sum = tmp;
            Integer gap = s.ceiling(sum - k);
            
            if(gap != null) {
                max = Math.max(max, sum - gap);
            }
            
            s.add(tmp);
        }
    
        return max;
    }
}