/**
 * https://leetcode.com/problems/accounts-merge/submissions/
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailIndexs = new HashMap();
        
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                
                if (!emailIndexs.containsKey(email)) {
                    emailIndexs.put(email, new ArrayList());
                }
                
                emailIndexs.get(email).add(i);
            }
        }
        
        boolean[] visited = new boolean[accounts.size()];
        List<List<String>> result = new ArrayList();
        
        for (int i = 0; i < accounts.size(); i++) {
            Set<String> emails = new TreeSet<String>();
            dfs(i, accounts, emailIndexs, visited, emails);
            
            if (!emails.isEmpty()) {
                List<String> emailList = new LinkedList<String>(emails);
                emailList.add(0, accounts.get(i).get(0));
                result.add(emailList);
            }
        }
        
        return result;
    }
    
    void dfs(int cur, List<List<String>> accounts, Map<String, List<Integer>> emailIndexs, boolean[] visited, Set<String> emails) {
        if (visited[cur]) {
            return;
        }
        
        visited[cur] = true;
        
        for (int i = 1; i < accounts.get(cur).size(); i++) {
            String email = accounts.get(cur).get(i);
            emails.add(email);
            
            for (int index : emailIndexs.get(email)) {
                dfs(index, accounts, emailIndexs, visited, emails);
            }
        }
    }
}