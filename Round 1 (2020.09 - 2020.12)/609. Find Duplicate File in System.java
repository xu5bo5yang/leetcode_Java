/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/submissions/
 */
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        if (paths == null || paths.length < 1) {
            return new ArrayList();
        }
        
        Map<String, List<String>> contentFileMap = new HashMap();
        
        for (String path : paths) {
            String[] splitted = path.split(" ");
            String dir = splitted[0];
            
            for (int i = 1; i < splitted.length; i++) {
                String file = splitted[i];
                int nameIndex = file.indexOf('(');
                String fileName = file.substring(0, nameIndex);
                String content = file.substring(nameIndex + 1, file.length() - 1);
                
                if (!contentFileMap.containsKey(content)) {
                    contentFileMap.put(content, new ArrayList());
                }
                
                contentFileMap.get(content).add(dir + "/" + fileName);
            }
        }
        
        return contentFileMap.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
    }
}