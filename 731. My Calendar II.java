/**
 * https://leetcode.com/problems/my-calendar-ii/submissions/
 */
class MyCalendarTwo {

    private List<int[]> events;
    private List<int[]> overlaps;
    
    public MyCalendarTwo() {
        events = new ArrayList();
        overlaps = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for (int[] event : events) {
            int overlapStart = Math.max(event[0], start);
            int overlapEnd = Math.min(event[1], end);
            
            if (overlapStart < overlapEnd) {
                for (int[] overlap: overlaps) {
                    if (Math.max(overlap[0], overlapStart) < Math.min(overlap[1], overlapEnd)) {
                        overlaps.clear();
                        
                        return false;
                    }
                }
                
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        } 
        
        events.add(new int[]{start, end});
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */