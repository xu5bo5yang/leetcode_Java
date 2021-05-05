/**
 * https://leetcode.com/problems/employee-importance/submissions/
 */
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        Map<Integer, Employee> idToEmployee = new HashMap();
        
        for (Employee employee : employees) {
            idToEmployee.put(employee.id, employee);
        }
        
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(idToEmployee.get(id));
        
        while (!queue.isEmpty()) {
            Employee current = queue.poll();
            result += current.importance;
            
            for (int subordinate : current.subordinates) {
                queue.offer(idToEmployee.get(subordinate));
            }
        }
        
        return result;
    }
}