/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/
 */
class RandomizedSet {
    
    List<Integer> valList;
    Map<Integer, Integer> valIndexMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valList = new ArrayList();
        valIndexMap = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valIndexMap.containsKey(val)) {
            return false;
        }
        
        valList.add(val);
        valIndexMap.put(val, valList.size() - 1);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valIndexMap.containsKey(val)) {
            return false;
        }
        
        int index = valIndexMap.get(val);
        
        Collections.swap(valList, index, valList.size() - 1);
        int swappedVal = valList.get(index);
        valIndexMap.put(swappedVal, index);
        
        valList.remove(valList.size() - 1);
        valIndexMap.remove(val);

        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        
        return valList.get(random.nextInt(valList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */