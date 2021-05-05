/**
 * https://leetcode.com/problems/range-sum-query-mutable/solution/
 */
class NumArray {

    int[] sums;
    
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        int diff = val - (sums[i+1] - sums[i]);
        
        for (int index = i + 1; index < sums.length; index++) {
            sums[index] += diff; 
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */