/**
 * https://leetcode.com/problems/course-schedule-iii/submissions/
 */
class Solution {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length < 1 || courses[0].length < 1) {
            return 0;
        }
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        
        for (int[] course : courses) {
            time += course[0];
            queue.add(course[0]);
            
            if (course[1] < time) {
                time -= queue.poll();
            }
        }
        
        return queue.size();
    }
}