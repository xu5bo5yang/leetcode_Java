/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/submissions/
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
            return new ArrayList();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));
        queue.add(new int[]{0, 0});
        
        while (k > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            
            List<Integer> sol = new ArrayList();
            sol.add(nums1[pair[0]]);
            sol.add(nums2[pair[1]]);
            result.add(sol);
            
            if (pair[0] + 1 < len1) {
                queue.add(new int[]{pair[0] + 1, pair[1]});
            }
            if (pair[0] == 0 && pair[1] + 1 < len2) {
                queue.add(new int[]{pair[0], pair[1] + 1});
            }
            
            k--;
        }
        
        return result;
    }
}