/**
 * https://leetcode.com/problems/restore-ip-addresses/submissions/
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList();
        int[] ip = new int[4];
        
        findResult(result, s, ip, 0, 0);
        return result;
    }
    
    void findResult(List<String> result, String s, int[] ip, int length, int block) {
        if (block == 4 && length == s.length()) {
            String ans = String.join(".", String.valueOf(ip[0]), String.valueOf(ip[1]), 
                                     String.valueOf(ip[2]), String.valueOf(ip[3]));
            result.add(ans);
            return;
        }
        
        if (block == 4 || length == s.length()) {
            return;
        }
        
        for (int k = 1; k <= 3 && length + k <= s.length(); k++) {
            int ipBlock = Integer.parseInt(s.substring(length, length+k));
            
            if (ipBlock > 255 || (k > 1 && s.charAt(length) == '0')) {
                break;
            }
            
            ip[block] = ipBlock;
            findResult(result, s, ip, length + k, block + 1);
            ip[block] = -1;
        }
    }
}