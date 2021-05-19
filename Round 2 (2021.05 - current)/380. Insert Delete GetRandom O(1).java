class RandomizedSet {
    
    private ArrayList<Integer> nums;
    private HashMap<Integer, Integer> index;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList();
        index = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (index.containsKey(val)) {
            return false;
        }
        
        nums.add(val);
        index.put(val, nums.size() - 1);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) {
            return false;
        }
        
        int valIndex = index.get(val);
        int lastNum = nums.get(nums.size() - 1);
        
        index.put(lastNum, valIndex);
        index.remove(val);
        nums.set(valIndex, lastNum);
        nums.remove(nums.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */