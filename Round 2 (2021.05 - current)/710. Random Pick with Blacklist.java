class Solution {
    
    private int range;
    private HashMap<Integer, Integer> index;
    
    public Solution(int N, int[] blacklist) {
        range = N - blacklist.length;
        index = new HashMap();
        
        for (int b : blacklist) {
            index.put(b, b);
        }
        
        int last = N - 1;
        
        for (int b : blacklist) {
            if (b >= range) {
                continue;    
            }
            
            while (index.containsKey(last)) {
                last--;
            }
            
            index.put(b, last);
            last--;
        }
    }
    
    public int pick() {
        Random random = new Random();
        int i = random.nextInt(range);
        
        return index.getOrDefault(i, i);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */