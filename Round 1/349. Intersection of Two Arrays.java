/**
 * https://leetcode.com/problems/intersection-of-two-arrays/submissions/
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet();
        Set<Integer> nums2Set = new HashSet();
        
        for (int num : nums1) {
            nums1Set.add(num);
        }
        
        for (int num : nums2) {
            nums2Set.add(num);
        }
        
        nums1Set.retainAll(nums2Set);
        
        int[] result = new int[nums1Set.size()];
        int i = 0;
        
        for (int num : nums1Set) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
}