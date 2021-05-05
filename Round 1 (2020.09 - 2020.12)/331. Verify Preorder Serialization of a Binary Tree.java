/**
 * 
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        int childrenMinusParent = 1;
        String[] nodes = preorder.split(",");
        
        for (String node : nodes) {
            childrenMinusParent--;
            
            if (childrenMinusParent < 0) {
                return false;
            }
            
            if (!node.equals("#")) {
                childrenMinusParent += 2;
            }
        }
        
        return childrenMinusParent == 0;
    }
}