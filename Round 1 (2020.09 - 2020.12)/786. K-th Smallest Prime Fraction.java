/**
 * https://leetcode.com/problems/k-th-smallest-prime-fraction/submissions/
 */
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        if (A == null || A.length < 2) {
            return new int[0];
        }
        
        int[] result = new int[2];
        PriorityQueue<int[]> queue = new PriorityQueue<>(A.length, (a,b) -> A[a[0]] * A[b[1]] - A[b[0]] * A[a[1]]);
        
        for(int i = 0; i < A.length - 1; i++) {
            queue.add(new int[]{i, A.length - 1});
        }
        
        int move = 1;
        
        while(move < K && !queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[1] - 1 > cur[0]) {
                cur[1]--;
                queue.add(cur);
            }
            
            move++;
        }
        
        result[0] = A[queue.peek()[0]];
        result[1] = A[queue.peek()[1]];
        
        return result;
    }
}