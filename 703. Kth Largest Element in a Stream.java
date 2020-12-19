/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/submissions/
 */
class KthLargest {
    int k;
    PriorityQueue<Integer> queue;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<Integer>(k);
        
        for (int num : nums) {
            queue.offer(num);
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        
        while (queue.size() > k) {
            queue.poll();
        }
        
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */