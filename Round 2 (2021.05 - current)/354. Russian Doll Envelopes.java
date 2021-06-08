class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        
        int[] height = new int[envelopes.length];
        
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        
        return lengthOfLIS(height);
    }
    
    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;

        Arrays.fill(dp, 1);
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}