/**
 * https://leetcode.com/problems/random-pick-with-blacklist/submissions/
 */
class Solution {
    private int range;
    private Set<Integer> blockSet;
    private Map<Integer, Integer> nums;
    
    public Solution(int N, int[] blacklist) {
        this.blockSet = new HashSet();
        this.nums = new HashMap();

        for(int num : blacklist){
            if(num >= N - blacklist.length) {
                blockSet.add(num);
            }
        }
        
        int val = N - blacklist.length;

        for(int num : blacklist){
            if(num < N - blacklist.length){
                while(blockSet.contains(val)) {
                    val++;
                }
                
                nums.put(num, val);
                val++;
            }
        }
        
        this.range = N - blacklist.length;   
    }
    
    public int pick() {
        Random random = new Random();
        int key = random.nextInt(range);
        
        return nums.getOrDefault(key,key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */