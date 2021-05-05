/**
 * https://leetcode.com/problems/number-of-atoms/submissions/
 */
class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack();
        Map<String,Integer> elementsCount = new HashMap();
        int i = 0;
        int len = formula.length();
        
        while (i < len) {
            char c = formula.charAt(i);
            i++;

            if (c == '(') {
                stack.push(elementsCount);
                elementsCount = new HashMap();
            } else if (c == ')') {
                int count = 0;
                
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + formula.charAt(i++) - '0';
                }

                
                if (count == 0) {
                    count = 1;
                }
                
                if (!stack.isEmpty()) {
                    Map<String,Integer> cur = elementsCount;
                    elementsCount = stack.pop();
                    
                    for (String element: cur.keySet()) {
                        elementsCount.put(element, elementsCount.getOrDefault(element, 0) + cur.get(element) * count);
                    }
                }
            } else {
                int start = i - 1;
                
                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                
                String element = formula.substring(start, i);
                int count = 0;
                
                while(i < len && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + formula.charAt(i++) - '0';
                }
                
                if (count == 0) {
                    count = 1;
                }
                
                elementsCount.put(element, elementsCount.getOrDefault(element, 0) + count);
            } 
        }
        
        StringBuilder result = new StringBuilder();
        List<String> elements = new ArrayList(elementsCount.keySet());
        
        Collections.sort(elements);
        
        for (String element: elements) {
            result.append(element);
            
            if (elementsCount.get(element) > 1) {
                result.append(elementsCount.get(element));
            }
        }
        
        return result.toString();
    }
}