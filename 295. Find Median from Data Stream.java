/**
 * https://leetcode.com/problems/find-median-from-data-stream/submissions/
 */
class MedianFinder {

    List<Integer> nums;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList();
    }
    
    public void addNum(int num) {
        int left = 0;
        int right = nums.size();
        int mid;
        
        while (left < right){
            mid = left + (right - left) / 2;
            
            if(num < nums.get(mid))
                right = mid;
            else 
                left = mid + 1;
        }
        
        nums.add(left, num);
    }
    
    public double findMedian() {
        int size = nums.size();
        
        if (size % 2 == 0) {
            return ((double) nums.get(size / 2 - 1) + nums.get(size / 2)) / 2;
        } else {
            return nums.get(size / 2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */