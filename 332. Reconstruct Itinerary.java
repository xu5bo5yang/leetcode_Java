/**
 * https://leetcode.com/problems/reconstruct-itinerary/submissions/
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() < 1) {
            return new ArrayList();
        }
        
        Map<String, PriorityQueue<String>> flights = new HashMap();
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        
        LinkedList<String> result = new LinkedList();
        String origin = "JFK";
        
        findDestination(result, flights, origin);
        
        return result;
    }
    
    void findDestination(LinkedList<String> result, Map<String, PriorityQueue<String>> flights, String origin) {
        if (flights.containsKey(origin)) {
            PriorityQueue<String> destinations = flights.get(origin);
            
            while (!destinations.isEmpty()) {
                String destination = destinations.poll();
                findDestination(result, flights, destination);
            }
        }

        result.offerFirst(origin);
    }
}