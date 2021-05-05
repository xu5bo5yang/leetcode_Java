/**
 * https://leetcode.com/problems/count-of-range-sum/submissions/
 */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        
        long[] sums = new long[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++){
            sums[i+1] = nums[i] + sums[i];
        }
        
        return mergesortCountRangeSum(sums, lower, upper, 0, sums.length - 1);
    }
    
    int mergesortCountRangeSum(long[] sums, int lower, int upper, int low, int high){
		if (low >= high) return 0;
		
		int mid = low + (high - low) / 2;
		int result = mergesortCountRangeSum(sums, lower, upper, low, mid) + mergesortCountRangeSum(sums, lower, upper, mid+1, high);
		int i = mid + 1;
        int j = mid + 1;
        
		for (int k = low; k <= mid; k++) {
			while (i <= high && sums[i] - sums[k] < lower) {
                i++;
            }
			
            while (j <= high && sums[j] - sums[k] <= upper) {
                j++;
            }
            
			result += j - i;
		}
		
		mergeCountRangeSum(sums, low, high);
		return result;
	}
	
	void mergeCountRangeSum(long[] sums, int low, int high){
		int mid = low + (high - low) / 2;
		int i = low;
        int j = mid + 1;
        int k = 0;
        long[] arr = new long[high - low + 1];
        
        while (k < arr.length){
            long num1 = i <= mid ? sums[i] : Long.MAX_VALUE;
            long num2 = j <= high ? sums[j] : Long.MAX_VALUE;
            
            if (num1 <= num2) {
                arr[k] = sums[i];
                i++;
            } else {
                arr[k] = sums[j];
                j++;
            }
            
            k++;
        }
        
        for (int p = 0; p < arr.length; p++) {
            sums[p + low] = arr[p];
        }
    }
}