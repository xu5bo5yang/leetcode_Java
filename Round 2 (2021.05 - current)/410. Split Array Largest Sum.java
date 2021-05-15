class Solution {
    public int splitArray(int[] nums, int m) {
        int maxNum = 0;
        int sum = 0;
        
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
            }
            
            sum += num;
        }
        
        int left = maxNum;
        int right = sum;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int subCount = split(nums, mid);
            
            if (subCount <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int split(int[] nums, int maxSum) {
        int count = 1;
        int curSum = 0;
        
        for (int num : nums) {
            if (curSum + num > maxSum) {
                curSum = num;
                count++;
            } else {
                curSum += num;
            }
        }
        
        return count;
    }
}