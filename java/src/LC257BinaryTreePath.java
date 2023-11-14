import java.util.ArrayList;
import java.util.List;

public class LC257BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res= new ArrayList<>();
        traverse(root, res, new ArrayList<>());
        return res;
    }

    public void traverse(TreeNode node, List<String> res, List<String> path) {
        if (node == null) {
            return;
        }
        path.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() -1 ; i++) {
                sb.append(path.get(i));
                sb.append("->");
            }
            sb.append(String.valueOf(node.val));
            res.add(sb.toString());
            return;
        }

        if (node.left != null) {
            traverse(node.left, res, path);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            traverse(node.right, res, path);
            path.remove(path.size() - 1);
        }
    }
}
