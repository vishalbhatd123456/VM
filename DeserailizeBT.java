/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Serialization -> conversion of a data strucgture into its sequence of bits
//This is the tech behind transfer of files and memory buffer

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    sb.append(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                }else{
                    sb.append("null");
                }
                if(!queue.isEmpty()){
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0 )return null;
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int index = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                String leftString = split[index++];
                String rightString = split[index++];
                if(!leftString.equals("null")){
                    TreeNode leftNode = new TreeNode(Integer.parseInt(leftString));
                    node.left = leftNode;
                    queue.add(leftNode);
                }
                if(!rightString.equals("null")){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(rightString));
                    node.right = rightNode;
                    queue.add(rightNode);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
