/**
 * https://leetcode.com/problems/task-scheduler/submissions/
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1) {
            return 0;
        }
        
        if (n == 0) {
            return tasks.length;
        }
        
        int[] count = new int[26];
        int maxCount = 0;
        
        for (char task : tasks) {
            count[task - 'A']++;
            maxCount = Math.max(maxCount, count[task - 'A']);
        }
        
        int maxTasks = 0;
        
        for (int c : count) {
            if (c == maxCount) {
                maxTasks++;
            }
        }
        
        int maxTime = (maxCount - 1) * (n + 1) + maxTasks;
        
        return Math.max(maxTime, tasks.length);
    }
}