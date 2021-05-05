/**
 * https://leetcode.com/problems/group-anagrams/submissions/
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<List<String>>();
        }
        
        Map<String, List<String>> anagramMap = new HashMap();
        
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            
            List<String> newList = anagramMap.containsKey(key) ? anagramMap.get(key) : new ArrayList<String>();            
            newList.add(strs[i]);
            anagramMap.put(key, newList);
        }
        
        List<List<String>> result = new ArrayList();
        for (List<String> value : anagramMap.values()) {
            result.add(value);
        }
        
        return result;
    }
}