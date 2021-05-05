/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums = new HashMap();
        List<Integer> numList = new ArrayList();

        for (int num : nums1) {
            nums.put(num, nums.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (nums.containsKey(num)){
                numList.add(num);
                nums.put(num, nums.get(num) - 1);
                nums.remove(num, 0);
            }
        }
        
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }
        
        return result;
    }
}