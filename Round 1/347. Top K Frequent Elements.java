/**
 * https://leetcode.com/problems/top-k-frequent-elements/submissions/
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap();
        
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int num : numToFreq.keySet()){
            int freq = numToFreq.get(num);
            
            if(buckets[freq]==null) {
                buckets[freq] = new LinkedList<>();
            }
            
            buckets[freq].add(num);
        }
        
        int[] result = new int[k];
        int index = 0;
        
        for(int i = buckets.length - 1; i > 0 && index < k; i--){
            if (buckets[i] != null) {
                List<Integer> list = buckets[i];
                
                for (int j = 0; j < list.size() && index < k; j++, index++) {
                    result[index] = list.get(j);
                }
            }
        }
        
        return result;
    }
}