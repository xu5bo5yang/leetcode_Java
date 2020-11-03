/**
 * https://leetcode.com/problems/evaluate-division/submissions/
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> pairValues = new HashMap<>();
        
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            
            pairValues.putIfAbsent(a, new HashMap<>());
            pairValues.putIfAbsent(b, new HashMap<>());
            
            pairValues.get(a).put(b, values[i]);
            pairValues.get(b).put(a, 1 / values[i]);
        }
        
        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            results[i] = findValue(queries.get(i).get(0), queries.get(i).get(1), 1, pairValues, new HashSet<>());
        }
        
        return results;
    }
    
    double findValue(String a, String b, double prev, Map<String, Map<String, Double>> pairValues, Set<String> visited) {
        if (!pairValues.containsKey(a) || visited.contains(a)) {
            return -1;
        }
        
        if (a.equals(b)) {
            return prev;
        }
        
        Map<String, Double> values = pairValues.get(a);
        visited.add(a);
        
        for (String c : values.keySet()) {
            double result = findValue(c, b, prev * values.get(c), pairValues, visited);
            
            if (result != -1) {
                return result;
            }
        }
        
        return -1;
    }
}