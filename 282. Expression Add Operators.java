/**
 * https://leetcode.com/problems/expression-add-operators/submissions/
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList();
        
        if (num != null && num.length() > 0) {
            findSolution(result, new StringBuilder(), num, target, 0, 0, 1);
        }
        
        return result;
    }
    
    void findSolution(List<String> result, StringBuilder prev, String num, int target, int pos, long prevNum, long multi) {
        if (pos == num.length()) {
		    if (target == prevNum) {
                result.add(prev.toString());
            }
		    
            return;
        }
        
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i != pos) {
                break;
            }
            
            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = prev.length();
            if(pos == 0) {
                findSolution(result, prev.append(cur), num, target, i + 1, cur, cur); 
                prev.setLength(len);
            } else {
                findSolution(result, prev.append("+").append(cur), num, target, i + 1, prevNum + cur, cur); 
                prev.setLength(len);
                
                findSolution(result, prev.append("-").append(cur), num, target, i + 1, prevNum - cur, -cur); 
                prev.setLength(len);
                
                findSolution(result, prev.append("*").append(cur), num, target, i + 1, prevNum - multi + multi * cur, multi * cur); 
                prev.setLength(len);
            }
        }
    }
}