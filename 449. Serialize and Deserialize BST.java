/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/submissions/
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
        StringBuilder sb = new StringBuilder();
        
        serialize(root, sb);
        
        return sb.toString();
    }
    
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("NULL").append(",");
        } else {
            sb.append(root.val).append(",");
            
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList();
        
        queue.addAll(Arrays.asList(data.split(",")));
        
        return deserialize(queue);
    }
    
    TreeNode deserialize(Queue<String> queue) {
        String s = queue.poll();
        
        if (s.equals("NULL")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;