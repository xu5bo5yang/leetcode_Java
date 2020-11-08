/**
 * https://leetcode.com/problems/all-oone-data-structure/submissions/
 */
class AllOne {
    
    Map<String, Integer> keyValues;
    Map<Integer, Set<String>> valueKeys;
    int maxValue;
    int minValue;

    /** Initialize your data structure here. */
    public AllOne() {
        keyValues = new HashMap();
        valueKeys = new HashMap();
        maxValue = 0;
        minValue = 0;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        keyValues.put(key, keyValues.getOrDefault(key, 0) + 1);
        
        int value = keyValues.get(key);
        if (valueKeys.get(value) == null) {
            valueKeys.put(value, new HashSet());
        }
        
        valueKeys.get(value).add(key);
        
        if (valueKeys.containsKey(value - 1)) {
            valueKeys.get(value - 1).remove(key);
            
            if (valueKeys.get(value - 1).size() == 0) {
                valueKeys.remove(value - 1);
            }
        }
        
        if (maxValue < value) {
            maxValue = value;
        }
        
        if (minValue == value - 1) {
            if (valueKeys.get(minValue) == null || valueKeys.get(minValue).size() == 0) {
                minValue = value;
            }
        }
        
        if (value == 1) {
            minValue = value;
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyValues.containsKey(key)) {
            if (keyValues.get(key) == 1) {
                keyValues.remove(key);
                valueKeys.get(1).remove(key);
                
                if(valueKeys.get(1).size() > 0){
                    minValue = 1;
                } else {
                    valueKeys.remove(1);
                    
                    if (keyValues.size() > 0){
                        minValue = Integer.MAX_VALUE;
                        
                        for (Map.Entry<Integer, Set<String>> entry : valueKeys.entrySet()){
                            if(entry.getValue().size() > 0)
                                minValue = Math.min(minValue, entry.getKey());
                        }
                    }else {
                        minValue = 0;
                        maxValue = 0;
                    }
                }
            } else {
                keyValues.put(key, keyValues.get(key) - 1);
                int value = keyValues.get(key);
                valueKeys.get(value + 1).remove(key);
                
                if (valueKeys.get(value + 1).size() == 0) {
                    valueKeys.remove(value + 1);
                }
                
                if (valueKeys.get(value) == null) {
                    valueKeys.put(value, new HashSet());
                }
                
                valueKeys.get(value).add(key);
                
                if(maxValue == value + 1){
                    if (valueKeys.get(maxValue) == null || valueKeys.get(maxValue).size() == 0) {
                        maxValue = value;
                    }
                }
                
                if(minValue == value + 1){
                    minValue = value;
                }
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (keyValues.size() == 0) {
            return "";
        } else {
            return valueKeys.get(maxValue).iterator().next();
        }
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (keyValues.size() == 0) {
            return "";
        } else {
            return valueKeys.get(minValue).iterator().next();
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */