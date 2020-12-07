/**
 * https://leetcode.com/problems/shopping-offers/submissions/
 */
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>, Integer> needsCount = new HashMap<>();
        
        return backTracking(price, special, needs, 0, needsCount);
    }
    
    int backTracking(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cur, HashMap<List<Integer>, Integer> needsCount) {
        if (price == null || price.size() == 0 || needs == null || needs.size() == 0) {
            return 0;
        }
        
        if (needsCount.containsKey(needs)) {
            return needsCount.get(needs);
        }
        
        int result = 0;
        
        for (int i = 0; i < price.size(); i++) {
            result += price.get(i) * needs.get(i);
        }
        
        for (int j = cur; j < special.size(); j++) {
            List<Integer> item = special.get(j);
            List<Integer> copy = new LinkedList<Integer>(needs);
            int i = 0;
            
            for (i = 0; i < copy.size(); i++) {
                if (copy.get(i) < item.get(i)) {
                    break;
                }
                
                copy.set(i, copy.get(i) - item.get(i));
            }
            
            if (i == copy.size()) {
                result = Math.min(result, item.get(i) + backTracking(price, special, copy, j, needsCount)); 
            }
        }

        needsCount.put(needs, result);
        
        return result;
    }
}