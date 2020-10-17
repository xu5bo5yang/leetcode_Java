/**
 * https://leetcode.com/problems/ugly-number-ii/submissions/
 */
class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> queue = new TreeSet();
        queue.add(1l);
        
        for (int i = 1; i < n; i++) {
            long prev = queue.pollFirst();
            
            queue.add(prev * 2);
            queue.add(prev * 3);
            queue.add(prev * 5);
        }
        
        return queue.pollFirst().intValue();
    }
}