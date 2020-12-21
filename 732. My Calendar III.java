/**
 * https://leetcode.com/problems/my-calendar-iii/submissions/
 */
class MyCalendarThree {

    private TreeMap<Integer, Integer> events;
    
    public MyCalendarThree() {
        events = new TreeMap();
    }
    
    public int book(int start, int end) {
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);
        
        int sum = 0;
        int k = 0;
        
        for (int count : events.values()) {
            sum += count;
            k = Math.max(k, sum);
        }
        
        return k;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */