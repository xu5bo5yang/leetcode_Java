/**
 * https://leetcode.com/problems/wiggle-sort-ii/submissions/
 */
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int n = nums.length;
        int oddIndex = 1;
        int evenIndex = (n - 1) / 2 * 2;
        int i = evenIndex;
        
        int mid = findKthLargest(nums, (n + 1) / 2);
                
        for (int k = 0; k < nums.length; k++) {
            if(nums[i] > mid){
                swap(nums, i, oddIndex);
                oddIndex += 2;
            } else if(nums[i] < mid) {
                swap(nums, i, evenIndex);
                evenIndex -= 2;
                i -= 2;
            } else {
                i -= 2;
            }
            
            if(i < 0) {
                i = n / 2 * 2 - 1;
            }
        }   
    }
    
    int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k);
        
        for (int n: nums) {
            if (queue.size() == k) {
                if (queue.peek() == null) {
                    queue.offer(n);
                } else if (n > queue.peek()) {
                    queue.poll();
                    queue.offer(n);
                }
            } else {
                queue.offer(n);
            }
        }

        return queue.peek();
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}