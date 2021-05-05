/**
 * https://leetcode.com/problems/validate-ip-address/submissions/
 */
class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        
        if (isIPv6(IP)) {
            return "IPv6";
        }
        
        return "Neither";
    }
    
    boolean isIPv4(String IP) {
        String[] ipv4 = IP.split("\\.", -1);
        
        if (ipv4.length != 4) {
            return false;
        }
        
        for (String block : ipv4) {
            try{
                if(Integer.parseInt(block) > 255 || (block.charAt(0) == '0' && block.length() > 1)) {
                    return false;
                }
            } catch (NumberFormatException e) { 
                return false; 
            }
        }
        
        return true;
    }
    
    boolean isIPv6(String IP) {
        String[] ipv6 = IP.split(":", -1);
        
        if (ipv6.length != 8) {
            return false;
        }
        
        for(String block: ipv6) {
            try{
                if(Integer.parseInt(block, 16) > 65535 || block.length() > 4) {
                    return false;
                }
            } catch (NumberFormatException e) { 
                return false; 
            }
        }
        
        return true;
    }
}