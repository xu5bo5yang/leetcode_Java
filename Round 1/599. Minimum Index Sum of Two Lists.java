/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/submissions/
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurantIndex = new HashMap();
        
        for (int i = 0; i < list1.length; i++) {
            restaurantIndex.put(list1[i], i);
        }
        
        List<String> result = new ArrayList();
        int minSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < list2.length; i++) {
            if (restaurantIndex.containsKey(list2[i])) {
                int sum = i + restaurantIndex.get(list2[i]);
                
                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(list2[i]);
                } else if (sum == minSum)
                    result.add(list2[i]);
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}