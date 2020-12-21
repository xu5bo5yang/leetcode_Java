/**
 * https://leetcode.com/problems/my-calendar-i/submissions/
 */
class MyCalendar {

    private List<int[]> events;
    
    public MyCalendar() {
        events = new ArrayList();    
    }
    
    public boolean book(int start, int end) {
        for (int[] event : events) {
            if (Math.max(event[0], start) < Math.min(event[1], end)) {
                return false;
            }
        }
        
        events.add(new int[]{start, end});
    
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */