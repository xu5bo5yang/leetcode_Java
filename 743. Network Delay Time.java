/**
 * https://leetcode.com/problems/network-delay-time/submissions/
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        
        for (int[] time: times) {
            graph.putIfAbsent(time[0], new ArrayList());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        boolean[] visited = new boolean[N + 1];
        int[] minTime = new int[N + 1];
        int max = 0;

        Arrays.fill(minTime, Integer.MAX_VALUE);
        
        minTime[K] = 0;
        queue.offer(new int[]{0, K});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[1];
            
            if (visited[node]) {
                continue;
            }
            
            visited[node] = true;
            int time = cur[0];
            max = time;
            N--;
            
            if (!graph.containsKey(node)) {
                continue;
            }
            
            for (int[] next : graph.get(node)) {
                if (!visited[next[0]] && time + next[1] < minTime[next[0]])
                    queue.offer(new int[]{time + next[1], next[0]});
            }
        }
        
        return N == 0 ? max : -1;
    }
}