/**
 * https://leetcode.com/problems/ipo/submissions/
 */
class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> profitQueue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        
        for (int i = 0; i < Profits.length; i++) {
            capitalQueue.add(new int[] {Capital[i], Profits[i]});
        }
        
        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && capitalQueue.peek()[0] <= W) {
                profitQueue.add(capitalQueue.poll());
            }
            
            if (profitQueue.isEmpty()) break;
            
            W += profitQueue.poll()[1];
        }
        
        return W;
    }
}