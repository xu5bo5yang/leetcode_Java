/**
 * https://leetcode.com/problems/find-k-closest-elements/submissions/
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
		int right = arr.length - 1;
        
		while (k <= right - left) {
			if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
				left++;
			} else {
				right--;
			}
		}
		
        List<Integer> result = new ArrayList();
		
        for (int i = left; i <= right; i++) {
			result.add(arr[i]);
		}
        
		return result;
    }
}