/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/submissions/
 */
class RandomizedCollection {

    List<Integer> valList;
    Map<Integer, Set<Integer>> valIndexMap;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        valList = new ArrayList();
        valIndexMap = new HashMap();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> indexes = valIndexMap.getOrDefault(val, new HashSet());
        
        boolean result = indexes.isEmpty();
        valList.add(val);
        indexes.add(valList.size() - 1);
        
        valIndexMap.put(val, indexes);
        
        return result;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!valIndexMap.containsKey(val) || valIndexMap.get(val).isEmpty()) {
            return false;
        }
        
        Set<Integer> indexes = valIndexMap.get(val);
        int index = indexes.iterator().next();
        indexes.remove(index);
        valIndexMap.put(val, indexes);
        
        int swappedVal = valList.get(valList.size() - 1);
        valList.set(index, swappedVal);
        Set<Integer> swappedIndexes = valIndexMap.get(swappedVal);
        swappedIndexes.add(index);
        swappedIndexes.remove(valList.size() - 1);
        valIndexMap.put(swappedVal, swappedIndexes);
        
        valList.remove(valList.size() - 1);

        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random random = new Random();
        
        return valList.get(random.nextInt(valList.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */