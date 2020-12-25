/**
 * https://leetcode.com/problems/prefix-and-suffix-search/submissions/
 */
class WordFilter {

    Map<String, List<Integer>> prefixMap;
    Map<String, List<Integer>> suffixMap;
    
    public WordFilter(String[] words) {
        prefixMap = new HashMap();
        suffixMap = new HashMap();
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= 10 && j <= words[i].length(); j++){
                String prefix = words[i].substring(0, j);
                
                prefixMap.putIfAbsent(prefix, new ArrayList());
                prefixMap.get(prefix).add(i);
            }
            
            for(int j = 0; j <= 10 && j <= words[i].length(); j++){
                String suffix = words[i].substring(words[i].length() - j);
                
                suffixMap.putIfAbsent(suffix, new ArrayList());
                suffixMap.get(suffix).add(i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        if(!prefixMap.containsKey(prefix) || !suffixMap.containsKey(suffix)) {
            return -1;
        }
        
        List<Integer> pre = prefixMap.get(prefix);
        List<Integer> suf = suffixMap.get(suffix);
        int i = pre.size() - 1;
        int j = suf.size() - 1;
        
        while(i >= 0 && j >= 0){
            if (pre.get(i) < suf.get(j)) {
                j--;
            } else if (pre.get(i) > suf.get(j)) {
                i--;
            } else {
                return pre.get(i);
            }
        }
        
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */