/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/submissions/
 */
class SummaryRanges {

    TreeMap<Integer, int[]> trees;
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        trees = new TreeMap();
    }
    
    public void addNum(int val) {
        if (trees.containsKey(val)) {
            return;
        }
        
        Integer low = trees.lowerKey(val);
        Integer high = trees.higherKey(val);
        
        if (low != null && high != null && trees.get(low)[1] + 1 == val && high == val + 1) {
            trees.get(low)[1] = trees.get(high)[1];
            trees.remove(high);
        } else if (low != null && trees.get(low)[1] + 1 >= val) {
            trees.get(low)[1] = Math.max(trees.get(low)[1], val);
        } else if (high != null && high == val + 1) {
            int[] range = new int[2];
            range[0] = val;
            range[1] = trees.get(high)[1];
            
            trees.put(val, range);
            trees.remove(high);
        } else {
            int[] range = new int[2];
            range[0] = val;
            range[1] = val;
            
            trees.put(val, range);
        }
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[trees.values().size()][2];
        int i = 0;
        
        for (int[] value : trees.values()) {
            result[i] = value;
            i++;
        }
        
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */