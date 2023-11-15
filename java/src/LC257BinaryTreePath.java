import java.util.ArrayList;
import java.util.List;

public class LC257BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res= new ArrayList<>();
        traverse(root, res, new StringBuilder());
        return res;
    }

    public void traverse(TreeNode node, List<String> res, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        int len=sb.length();

        if (node.left == null && node.right == null) {
            res.add(sb.toString());
            return;
        }
        if (node.left != null) {
            sb.append("->");
            traverse(node.left, res, sb);
            sb.delete(len, sb.length());
        }
        if (node.right != null) {
            sb.append("->");
            traverse(node.right, res, sb);
            sb.delete(len, sb.length());
        }
    }
}
