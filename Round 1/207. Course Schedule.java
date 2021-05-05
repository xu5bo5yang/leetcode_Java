/**
 * https://leetcode.com/problems/course-schedule/submissions/
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return false;
        }
        
        if (prerequisites == null || prerequisites.length == 0 || 
            prerequisites[0].length == 0) {
            return true;
        }
        
        int[][] edges = new int[numCourses][numCourses];
        int[] preCount = new int[numCourses];
        Queue<Integer> startingCourses = new LinkedList();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int coursePre = prerequisites[i][1];
            
            edges[coursePre][course] = 1;
            preCount[course]++;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (preCount[i] == 0) {
                startingCourses.add(i);
            }
        }
        
        int count = numCourses;
        while (startingCourses.size() > 0) {
            int course = startingCourses.poll();
            count--;
            
            for (int i = 0; i < numCourses; i++) {
                if (edges[course][i] != 0) {
                    preCount[i]--;
                    
                    if (preCount[i] == 0) {
                        startingCourses.add(i);
                    }
                }
            }
        }
        
        return count == 0;
    }
}