/**
 * https://leetcode.com/problems/gray-code/submissions/
 */
class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList();
            result.add(0);
            
            return result;
        }
        
        List<String> result = new ArrayList();
        result.add("");
        
        for (int i = 1; i <= n; i++) {
            List<String> prev = result;
            int newLength = (int) Math.pow(2, i);
            String[] newResult = new String[newLength];

            for (int k = 0; k < newLength / 2; k++) {
                String s = prev.get(k);
                newResult[k] = "0" + s;
                newResult[newLength-k-1] = "1" + s;
            }

            result = Arrays.asList(newResult);
        }
                
        return result.stream().map(c -> Integer.valueOf(c, 2)).collect(Collectors.toList());
    }
}