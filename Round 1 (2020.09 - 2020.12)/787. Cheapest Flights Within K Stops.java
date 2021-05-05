/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights == null || flights.length < 1 || flights[0].length < 1) {
            return -1;
        }
        
        int[] cost = new int[n];
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[src] = 0;
        
        for (int i = 0; i <= K; i++) {
            int[] tmp = Arrays.copyOf(cost, n);
            
            for (int[] flight : flights) {
                int cur = flight[0];
                int next = flight[1];
                
                if (cost[cur] == Integer.MAX_VALUE) {
                    continue;
                }
                
                tmp[next] = Math.min(tmp[next], cost[cur] + flight[2]);
            }
            
            cost = tmp;
        }
        
        return cost[dst] != Integer.MAX_VALUE ? cost[dst] : -1;
    }
}