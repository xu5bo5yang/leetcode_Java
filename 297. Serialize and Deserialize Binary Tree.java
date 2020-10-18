/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/submissions/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "X";
        }
        
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);
        
        return root.val + "," + leftSerialized + "," + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        
        nodes.addAll(Arrays.asList(data.split(",")));
        
        return deserializeTree(nodes);
    }
    
    TreeNode deserializeTree(Queue<String> nodes) {
        String val = nodes.poll();
        
        if(val.equals("X")) {
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left  = deserializeTree(nodes);
        node.right = deserializeTree(nodes);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));