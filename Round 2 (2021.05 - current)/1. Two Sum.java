class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap();
        int index1 = -1;
        int index2 = -1;
        
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            
            if (index.containsKey(need) && index.get(need) != i) {
                index1 = i;
                index2 = index.get(need);
                
                break;
            }
        }
        
        int[] result = new int[2];
        result[0] = index1;
        result[1] = index2;
        
        return result;
    }
}