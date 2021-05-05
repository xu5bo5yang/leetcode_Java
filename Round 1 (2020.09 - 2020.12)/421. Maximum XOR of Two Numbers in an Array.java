/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/submissions/
 */
class Solution{
    class Trie {
        Trie[] children;
        
        Trie() { 
            children = new Trie[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0; 
        }
        
        Trie root = new Trie();
        int result = 0;
        
        for(int num: nums) {
            Trie current = root;
            Trie complement = root;
            int value = 0;
            
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                
                if (current.children[bit] == null) {
                    current.children[bit] = new Trie(); 
                }
                
                current = current.children[bit];
                
                if (complement.children[1-bit] != null) {
                    complement = complement.children[1-bit]; value += (1<<i);
                } else {
                    complement = complement.children[bit];
                }
            }
            
            result = Math.max(result, value);
        }
        
        return result;
    }
}