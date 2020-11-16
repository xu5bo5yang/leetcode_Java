/**
 * https://leetcode.com/problems/sliding-window-median/submissions/
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new double[0];
        }
        
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> minQueue = new PriorityQueue();
        PriorityQueue<Integer> maxQueue = new PriorityQueue(
            new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b.compareTo(a);
                }
            }
        );
        

        for(int i = 0; i < nums.length; i++) {
            if(maxQueue.size() <= minQueue.size()) {
                minQueue.add(nums[i]);
                maxQueue.add(minQueue.remove());
            } else {
                maxQueue.add(nums[i]);
                minQueue.add(maxQueue.remove());
            }


            if(maxQueue.size() + minQueue.size() == k) {
                double median;
                
                if(maxQueue.size() == minQueue.size()) {
                    median = (double) ((long)maxQueue.peek() + (long)minQueue.peek()) / 2;
                } else {
                    median = (double) maxQueue.peek();
                }

                int start = i - k + 1;
                result[start] = median;
                
                if(!maxQueue.remove(nums[start])) {
                    minQueue.remove(nums[start]);
                }
            }
        }
        
        return result;
    }
}