/**
 * https://leetcode.com/problems/next-greater-element-i/submissions/
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new int[0];
        }
        
        Map<Integer, Integer> nextGreater = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack();
        
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            
            stack.push(num);
        }   
        
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }
}