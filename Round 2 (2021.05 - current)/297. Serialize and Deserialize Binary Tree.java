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

    private static final String DEL = ",";
    private static final String NULL = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        serialize(root, sb);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList();
        
        for (String val : data.split(DEL)) {
            nodes.add(val);
        }
        
        return deserialize(nodes);
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL);
            sb.append(DEL);
            
            return;
        }
        
        sb.append(root.val);
        sb.append(DEL);
        
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
    
    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return null;
        }
        
        String val = nodes.removeFirst();
        
        if (val.equals(NULL)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
